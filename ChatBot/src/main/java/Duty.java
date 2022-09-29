import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Duty {

    public static String getDuty() throws IOException, ParseException {

        String pathToXLSX = "C:\\java\\ChatBot\\src\\main\\resources\\duty.xls";

        String duty = cellTxt(pathToXLSX);

        return duty;
    }

    private static String cellTxt(String file) throws ParseException {

        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + " | ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:

                        if (DateUtil.isCellDateFormatted(cell)) {

                            DateFormat df = new SimpleDateFormat("dd:MM:YYYY ");

                            DateFormat format = new SimpleDateFormat("dd:MM");

                            result += df.format(cell.getDateCellValue()) + " | ";
                        } else {
                            result += cell.getNumericCellValue() + " | ";
                        }
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        result += cell.getNumericCellValue() + " | ";
                        break;
                    default:
                        result += " | ";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }

}

