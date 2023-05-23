package com.example.OrgJavaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@SpringBootApplication
public class OrgJavaRestApplication {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		SpringApplication.run(OrgJavaRestApplication.class, args);
		InitDatabase dbCon = new InitDatabase();
		SendRequest sr = new SendRequest();
		dbCon.initDatabase();
		dbCon.readTxtIntoArray();
		sr.sendRequest();
		//
	}

}
