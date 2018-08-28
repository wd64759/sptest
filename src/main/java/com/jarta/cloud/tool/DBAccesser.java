package com.jarta.cloud.tool;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ServiceLoader;

public class DBAccesser {

	public static void main(String[] args) throws SQLException {
		
		ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
		Iterator<Driver> driversIterator = loadedDrivers.iterator();
		 while(driversIterator.hasNext()) {
             Driver d = driversIterator.next();
             System.out.println(d.getClass());
         }
		
		String user = "sa", pcode = "";
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", user, pcode)) {
			DatabaseMetaData dmd = conn.getMetaData();
			System.out.println(dmd.getTypeInfo());
		}
	}

}
