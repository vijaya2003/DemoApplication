package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelpers {
	static XSSFSheet sheet;
	static int rowCount;
	static int colCount;
	public static String[][] returnExceldata() throws IOException {
		// TODO Auto-generated method stub
		File file = new File(System.getProperty("user.dir")+"//src//test//resources//original1.xlsx");
//		File file1 = new File("https://qualizeal-my.sharepoint.com/:x:/p/dasari_vijaya/EaG5KFElg7xDndFIiFg-xI8BiBL4JZ83j0afyk2Z21zLiQ?e=ZlrstY");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		rowCount=sheet.getLastRowNum();
		colCount=sheet.getRow(0).getLastCellNum();		
		String[][] val = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				DataFormatter d=new DataFormatter();
				val[i-1][j] = d.formatCellValue(sheet.getRow(i).getCell(j));	
			}
		}
		wb.close();
		fis.close();
		return val;
		
	}
	

}
