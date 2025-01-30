import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;

public class day1 { 
    public static void main(String[] args) throws FileNotFoundException {

        //part one 
        File input = new File("2024/day1_input.txt");
        Scanner sc = new Scanner(input);
        int total = 0; 
        int one[] = new int[1000];
        int two[] = new int[1000];
        int counter = 0;
        while(counter < 1000) {
            one[counter] = sc.nextInt();
            two[counter] = sc.nextInt();
            counter++;
        }
        sc.close();

        Arrays.sort(one);
        Arrays.sort(two);



        for(int i = 0; i < 1000; i++) {
            total += Math.abs(one[i] - two[i]);
        }



        System.out.println(total);


        //part two
        int similarity = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : two) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i : one) {
            int freq = map.getOrDefault(i, 0);
            similarity += freq * i;
        }

        System.out.println(similarity);
    }
}