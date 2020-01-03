package mainapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitInput {

    public static String[] splitInputByLine(String masses){
        return masses.split("\n");
    }

    public static List<Integer> splitInputByCommar(String intcodeString){
        return Arrays.stream(intcodeString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
