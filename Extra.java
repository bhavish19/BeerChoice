/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author bhavm
 */
public class Extra {
    static ArrayList<String> beer = new ArrayList<String>();
    static ArrayList<String> drink = new ArrayList<String>();
    
    
    public static long toHash(String s){
        return(s.hashCode());
    }  
    
    public static void Randomize(long seed){
        Random rand = new Random(seed);
        beer.add("Stella Artois");
        beer.add("Budweiser");
        beer.add("Corona Extra");
        
        while (beer.size()>0){
            int index = rand.nextInt(beer.size());
            drink.add(beer.get(index));
            beer.remove(index);
        }
    }
    
    public static void checkWord(String s){
        try{
            String lstr = s.toLowerCase();
            BufferedReader br = new BufferedReader(new FileReader("word.txt"));
            String line;
            while ((line = br.readLine())!=null){
                if (line.equals(lstr)){
                    System.out.println("'" + s + "' is already used!");
                    System.exit(0);
                }
            }
            FileWriter fw =new FileWriter("word.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(lstr);
            pw.close();
            bw.close();
            fw.close();
        }
        catch (IOException io){}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateft = new SimpleDateFormat("EE dd MMM  ");
        Date date = new Date();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter word of the day: ");
        String str = scan.nextLine();
        checkWord(str);
        long hashedvalue = toHash(str);
        Randomize(hashedvalue);
        
        
        
        for(int i=0;i<drink.size();i++){
            System.out.print(dateft.format(c.getTime()));
            System.out.println(drink.get(i));
            c.add(Calendar.DATE, 1);
        }
        

    }
    
}
