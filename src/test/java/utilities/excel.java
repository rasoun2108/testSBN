package utilities;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	
	public  String username;
	public  String password;
	public  String Tag;
	public  String Desc;
	public  String FilePath;
	public  String Title;
	
	

	public String xlutil(String args) throws IOException {
		
		String fip = "C:\\Users\\nveenrm\\eclipse-workspace\\testSBNetwork\\testData\\Login-testData1.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(fip);
		XSSFSheet sheet = workbook.getSheetAt(0);
	               
		XSSFRow row = sheet.getRow(1);
		
		XSSFCell uName = row.getCell(0);
		      username = uName.getStringCellValue();
	  
	  XSSFCell pwd = row.getCell(1);
	  password = pwd.getStringCellValue();
	  
	  XSSFCell title = row.getCell(2);
	  Title = title.getStringCellValue();
	  
	  XSSFCell desc = row.getCell(3);
	  Desc = desc.getStringCellValue();
	  
	  XSSFCell tag = row.getCell(4);
	  Tag = tag.getStringCellValue();
	  
	  XSSFCell filePath = row.getCell(5);
	  FilePath = filePath.getStringCellValue();
	  
	  
	String[] Data = {username + " " +  password +" "+ Title +" "+ Tag +" "+ Desc +" "+ FilePath};
		String	data1 = Data.toString();
	
		workbook.close();	
		
	return data1;
	  

	}

	
}
