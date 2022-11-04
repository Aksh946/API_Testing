package Com.Automation.genericUtils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;
	
	 public XL(String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
	}
	 
	 public int getrowCount(String SheetName) throws IOException {
		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet= workbook.getSheet(SheetName);
		 int rowcount = sheet.getLastRowNum();
		 workbook.close();
		 fi.close();
		 return rowcount;
		 
		 
	 }
	 public int getcellCount(String sheetName,int rowNum) throws IOException {
		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet= workbook.getSheet(sheetName);
		 row =sheet.getRow(rowNum);
		 int Cellcount = row.getLastCellNum();
		 workbook.close();
		 fi.close();
		 return Cellcount;
		 
	 }
	 
	 public String getCellData(String sheetName,int rownum,int colnum) throws IOException {
		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet= workbook.getSheet(sheetName);
		 row =sheet.getRow(rownum);
		 cell=row.getCell(colnum);
		 
		 DataFormatter formatter = new DataFormatter();
		 String data;
		 try {
			 data= formatter.formatCellValue(cell);
			 
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 data="";
		}
		 workbook.close();
		 fi.close();
		 return data;

		 
	 }
	 
}
