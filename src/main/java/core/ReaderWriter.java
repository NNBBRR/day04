package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriter {

    public static void main( String[] args ) {


    try {
        BufferedReader br = new BufferedReader(
        new FileReader("/Users/ngbingrong/vttp22"));

        String line;

            while ((line = br.readLine()) != null) {
                //method
                System.out.println(line);

            } br.close();
            
        }catch (Exception ex) {
            return;
            }
        
            try {
            BufferedWriter wr = new BufferedWriter(
                new FileWriter("/Users/ngbingrong/vttp22"));

                    wr.write("Hello");       
                    wr.close();
                    
                }catch (Exception ex) {
                    return;
                    
                }







    }


    
}
