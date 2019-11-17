package excel;

import java.awt.HeadlessException;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class excel_class extends Base{

	static String folderpath=GetConfig("excelfolderpath");
	static Sheet sh;
	static Workbook wb;
	static WritableWorkbook wwb;
	WritableSheet wsh;
	
	public static void excelConnection(String filename, String sheetname)
	{
		try {
			File f = new File(folderpath+filename);
			Workbook wb=Workbook.getWorkbook(f);
			Sheet sh=wb.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	public static int rows()
	{
		int rows=sh.getRows();
		return rows;
	}
	public static void columns()
	{
		int cols=sh.getColumns();
	}	
	public static String readdata(int col, int rows)
	{
		String data=sh.getCell(col, rows).getContents();
		return data;
	}
	public static void outputexcelconnection(String ifilename, String ofilename, String sheetname)
	{
		
			try {
				FileInputStream fis = new FileInputStream(folderpath+ifilename);
				wb=Workbook.getWorkbook(fis);
				sh=wb.getSheet(sheetname);
				
				FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
				WritableWorkbook wwb=Workbook.createWorkbook(fos, wb);
				WritableSheet wsh=wwb.getSheet(sheetname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	/*public static void writedata()
	{
		try {
			Label l = new Label();
			wsh.addcells(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
