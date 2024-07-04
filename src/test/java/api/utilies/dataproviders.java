package api.utilies;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataproviders {
	
	@DataProvider(name="Data")
	
	public String[][] getalldata() throws IOException
	
	{
		String path=System.getProperty("user.dir")+"//usertestdata.xlsx";
		Xcelutility xl=new Xcelutility(path);
		
		 int rownum=xl.getRowCount("sheet1");
		 int colcount=xl.getcellCount("sheet1",1);
		 
		 
		 String apidata[][]=new String[rownum][colcount];
		 
		 for(int i=1;i<=rownum;i++)
		 {
			 for(int j=0;j<colcount;j++)
			 {
				 apidata[i-1][j]=xl.getcelldata("sheet1", i, j);
			 }
		 }
		 return apidata;
	}
	
    @DataProvider(name="usernames")
	
	public String[] getusernames() throws IOException
	
	{
		String path=System.getProperty("user.dir")+"//usertestdata.xlsx";
		Xcelutility xl=new Xcelutility(path);
		
		 int rownum=xl.getRowCount("sheet1");
		
		 
		 
		 String apidata[]=new String[rownum];
		 
		 for(int i=1;i<=rownum;i++)
		 {
			 
				 apidata[i-1]=xl.getcelldata("sheet1", i, 1);
			 
		 }
		 return apidata;
	}
	
	
}
