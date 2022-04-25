package configExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./testData/config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		System.out.println("fetch user details form file: " +prop.getProperty("adminUserName1"));

	}

}
