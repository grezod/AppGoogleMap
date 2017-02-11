package map92.iii.org.tw.appgooglemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/1/22.
 */

public class CSVReader {
    InputStream inputstream;

    public CSVReader(InputStream is) {
        this.inputstream = is;
    }

    public List<String[]> read(){
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));

        try {
            String csvLine = reader.readLine();
            while(csvLine != null){
                String[] row = csvLine.split(",");
                resultList.add(row);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file:"+ ex);
        }finally {
            try {
                inputstream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream:"+ e);
            }
        }
        return resultList;
    }
}
