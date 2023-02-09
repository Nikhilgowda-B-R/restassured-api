package cancelAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {
	static FileInputStream  fis;
	
	public static int countRows(String path,String sheet) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream(path);
		int count=WorkbookFactory.create(fis).getSheet(sheet).getLastRowNum();
		return count;
	}
	
	
	public static String getData(String path,String sheet, int row, int col) throws EncryptedDocumentException, IOException {
		CellType type=CellType.STRING;
		fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheet).getRow(row).getCell(col);
		try {
			type = cell.getCellType();
		} catch (Exception e) {
			return null;
		}
		
		
		switch (type) {
		case NUMERIC: String data=String.valueOf((int)cell.getNumericCellValue());
						return data;

		default:return cell.getStringCellValue();
			
		}
		//System.out.println(data);
	}
	
	public static void setData(String path,String sheet,int row,int col,String print) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(print);
		FileOutputStream fos =new FileOutputStream(path);
		wb.write(fos);
		wb.close();
	}
}
