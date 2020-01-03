package mainapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
    //TODO add exceptions + try and catch for importing the file

    // TODO add files to correct folder under AdventOfCode

    public static final String DAY_1 = "/Users/longmuirj/Documents/Practice/adventOfCode2019/DataAdventOfCode/input_day1.txt";
    public static final String DAY_2 = "/Users/longmuirj/Documents/Practice/adventOfCode2019/DataAdventOfCode/input_day2.txt";
    public static final String DAY_3 = "/Users/longmuirj/Documents/Practice/adventOfCode2019/DataAdventOfCode/input_day3.txt";
    public static final String DAY_4 = "240298-78496";

    public String importFile(String inputFile) throws IOException {
        StringBuilder returnString = new StringBuilder();
        try (FileReader fr = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {
                returnString.append((char) i);
            }
            br.close();
        }
        return returnString.toString();
    }

}
