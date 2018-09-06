
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 *poi工具类
 */
@SuppressWarnings("unchecked")
public class PoiUtil<T> {
	public void exportExcel(String title, List<String> headerName, List<T> dtoList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//创建一个excel文件
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表
		XSSFSheet sheet = workbook.createSheet(title);
		//设置样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		
		//行计数器
		int rowCount = 0;
		
		//设置表头
		XSSFRow row = sheet.createRow(rowCount);
		XSSFCell cell;
		for (int i = 0; i < headerName.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerName.get(i));
			cell.setCellStyle(cellStyle);
		}
		
		//添加数据内容
		Iterator<T> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			rowCount++;
			row = sheet.createRow(rowCount);
			T t = iterator.next();
			 // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();//获得JavaBean全部属性
            for (short i = 0; i < 20; i++) {
				Field field = fields[i];
				String fieldName = field.getName(); //获取属性名
				String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);//拿到属性的get方法
				Class tClass = t.getClass(); //获取到对象
				Method getMethod = tClass.getMethod(getMethodName,
                        new Class[] {});//通过JavaBean对象拿到该属性的get方法，从而进行操控
				Object val = getMethod.invoke(t, new Object[] {});//操控该对象属性的get方法，从而拿到属性值
                String textVal = null;
                if (val!= null) {
                    textVal = String.valueOf(val);//转化成String
                }else{
                    textVal = null;
                }
                row.createCell((short) i).setCellValue(textVal);//写进excel对象
            }
		}
		  try {
	            FileOutputStream exportXls = new FileOutputStream("E://工单信息表.xls");
	            workbook.write(exportXls);
	            exportXls.close();
	            System.out.println("导出成功!");
	        } catch (FileNotFoundException e) {
	            System.out.println("导出失败!");
	            e.printStackTrace();
	        } catch (IOException e) {
	            System.out.println("导出失败!");
	            e.printStackTrace();
	        }
		
		
	}
}