package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders  {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		ExcelUtility utility=new ExcelUtility("C:\\Users\\pauls\\eclipse-workspace\\opencart_2506\\testData\\Opencart_LoginData.xlsx");
		int rows=utility.getRowCount("Sheet1");
		int columns=utility.getCellCount("Sheet1", 1);
		String logindata[][]=new String[rows][columns];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<columns;j++)
			{   
				
				logindata[i-1][j]=utility.getCellData("Sheet1", i, j);
				
						
			}
			
		}
		
		return logindata;
		
		
	}
	
	
	

}
