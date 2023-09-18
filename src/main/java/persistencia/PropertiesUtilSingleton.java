package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilSingleton {

	private static PropertiesUtilSingleton instancia;
	Properties properties = new Properties();

	private String driver = "driver";
	private String connectionString = "connectionString";
	private String databaseUser = "databaseUser";
	private String databasePass = "databasePass";

	private PropertiesUtilSingleton() {
		try {
			properties.load(new FileInputStream("C:\\DAW\\Proyectos VSC\\persistencia\\src\\main\\resources\\persitencia.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static PropertiesUtilSingleton getInstance() {
		if (instancia == null)
			instancia = new PropertiesUtilSingleton();
		return instancia;
	}

	public String getDriver(){
		return properties.getProperty(driver);
	}
	public String getconnectionString(){
		return properties.getProperty(connectionString);
	}
	public String getdatabaseUser(){
		return properties.getProperty(databaseUser);
	}
	public String getdatabasePass(){
		return properties.getProperty(databasePass);
	}

}
