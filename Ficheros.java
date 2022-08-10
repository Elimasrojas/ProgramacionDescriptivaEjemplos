/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplolambdas1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 *
 * @author elkin
 */
public class Ficheros {
    public static void main(String[] args) {
        try (FileReader fr= new FileReader("direccion");
                BufferedReader br= new BufferedReader(fr)){   
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            
        } catch (Exception e) {
        }
        String dir="";
        File file=new File(dir);
        try (FileInputStream fis= new FileInputStream(file)){
            byte[] res;
            res = new byte[(int)file.length()];
            fis.read(res);
            
        } catch (Exception e) {
        }
    }
    
}
