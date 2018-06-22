import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean isValid(String s){
        char a, b;
        if(s.length() >= 1){
            a = s.charAt(0);
            if(s.length() >= 2){
                b = s.charAt(1);
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == a){
                if((i+1) < s.length()){
                    if(s.charAt(i+1) == b && s.charAt(i) != s.charAt(i+1)){
                        ++i;
                    }   
                    else{
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    static ArrayList<Character> distinctChars(String s){
        ArrayList<Character> chars = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
            if(!chars.contains(s.charAt(i))){
                chars.add(s.charAt(i));
            }
        }
        return chars;
    }
    
    // Complete the twoCharaters function below.
    static int twoCharaters(String s) {

        boolean valid = isValid(s);
        if(valid){
            return s.length();
        }
        else if(!valid && s.length() < 3){return 0;}
        else{
            ArrayList<Character> chars = distinctChars(s);
            int nChars = chars.size();
            //System.out.println(nChars);
            //System.out.println(chars);
            //int N = nChars*(nChars-1)/2;
            int maxT = 0;
            for(int i = 0; i < nChars; i++){
                for(int j = i+1; j < nChars; j++){
                    String str = s;
                    char a = chars.get(i);
                    char b = chars.get(j);
                    for(int k = 0; k < nChars; k++){
                        char c = chars.get(k);
                        //System.out.println(a + " "+ b + " " + c);
                        if(c != a && c != b){
                            //System.out.println("replacing");
                            //StringUtils.remove(str, c);
                            str = str.replace(String.valueOf(c), "");
                            //System.out.println(str);
                        }
                    }
                    //System.out.println(str);
                    if(isValid(str) && str.length() > maxT){
                        maxT = str.length();
                        //System.out.println(str);
                        //System.out.println(maxT);
                    }
                    /*if(str.length() == 6){
                        System.out.println(str);
                    }*/
                }
            }
            return maxT;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = twoCharaters(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}




