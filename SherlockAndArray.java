import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    static String solve(int[] a){
        // Complete this function
        if(a.length == 1) return "YES";
        if(a.length == 2) return "NO";
        int rightSum = IntStream.of(a).sum();
        int leftSum = 0;
        
        for(int i = 1; i < a.length; i++){
            leftSum += a[i-1];
            if(i == 1) rightSum -= a[i-1];
            rightSum -= a[i];
            if(leftSum == rightSum){
                return "YES";
            }
            if(leftSum > rightSum) return "NO";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
