package mainapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitInput {

    public static String[] splitInputByLine(String masses){
        return masses.split("\n");
    }

    public static List<Integer> splitInputByCommarNumbersOnly(String intcodeString){
        return Arrays.stream(intcodeString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<String>> splitCrossedWires(String intcodeString){
        List<List<String>> finalList = new ArrayList<>();
        Arrays.stream(intcodeString.split("\n")).forEach(s -> {
            List<String> wires = Arrays.asList(s.split(","));
            finalList.add(wires);
        });
        return finalList;
    }


}
