package com.example.OrgJavaRest;

import com.example.OrgJavaRest.controller.AdultController;
import com.example.OrgJavaRest.model.AdultTrainJava;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitDatabase {
    private static final Logger logger = LogManager.getLogger(InitDatabase.class);
    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\intelijWorkspace\\OrgJavaRest\\JavaProject.db");
    public List<AdultTrainJava> adultTrainJavaList = new ArrayList<AdultTrainJava>();

    public InitDatabase() throws SQLException {
    }

    public void initDatabase() throws SQLException {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS ADULT_TRAIN_JAVA (RECORD_ID int NOT NULL PRIMARY KEY,AGE int,WORKCLASS VARCHAR(30),FNLWGT int,EDUCATION VARCHAR(30),EDUCATION_NUM int,MARITAL_STATUS VARCHAR(30),OCCUPATION VARCHAR(30),RELATIONSHIP VARCHAR(30),RACE VARCHAR(30),SEX VARCHAR(30),CAPITAL_GAIN int,CAPITAL_LOSS int,HOURS_PER_WEEK int,COUNTRY VARCHAR(30),PROXY VARCHAR(30),TARGET int,PART_DATE VARCHAR(30))";
           try {
                PreparedStatement pt = conn.prepareStatement(sql);
                pt.execute();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readTxtIntoArray() throws FileNotFoundException, SQLException {
        try {
            logger.debug("Database init method started");
            File myObj = new File("C:\\Users\\USER\\intelijWorkspace\\OrgJavaRest\\Adult_train_data_sqlite.txt");

            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(i == 0){
                    i++;
                    continue;
                }
                adultTrainJavaList.add(new AdultTrainJava(data));
                logger.debug("inserting "+ (i-1) + " th element");
                System.out.println("inserting "+ (i-1) + " th element");
                insertDb(adultTrainJavaList.get(i-1));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            logger.debug("Database init method ended");
            conn.close();
        }
    }

    public void insertDb(AdultTrainJava at) throws SQLException {
        Statement  statement = conn.createStatement();
        String query = String.format("INSERT INTO ADULT_TRAIN_JAVA VALUES('%d', '%d', '%s', '%s', '%s', '%d', '%s','%s', '%s'," +
                        " '%s', '%s', '%d', '%d', '%d', '%s', '%s', '%d', '%s')",
                at.getRecordId(),                at.getAge(),                at.getWorkclass(),
                at.getFnlwgt(),                at.getEducation(),                at.getEducationNum(),
                at.getMaritalStatus(),                at.getOccupation(),                at.getRelationship(),
                at.getRace(),                at.getSex(),                at.getCapitalGain(),
                at.getCapitalLoss(),                at.getHoursPerWeek(),                at.getCountry(),
                at.getProxy(),                at.getTarget(),                at.getPartDate());

        statement.execute(query);
    }
}
