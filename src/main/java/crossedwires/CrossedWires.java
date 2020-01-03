package crossedwires;

import mainapp.FeatureHandler;
import mainapp.ImplimentRunner;
import mainapp.SplitInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrossedWires implements ImplimentRunner {
    List<List<String>> allWires = new ArrayList<>();
    List<String> wireOne = new ArrayList<>();
    List<String> wireTwo = new ArrayList<>();



    // split into two wires
    // for each, save coordinates?
    // list a = 0,0|0,1|0,2|1,2| etc.
    // list b = 0,0|1,0|1,1|1,2| etc.
    // check each crossover + get all doubles
    // calculate which is lowest.


    @Override
    public String run(String inputFile) {
        String result = "";
        allWires = SplitInput.splitCrossedWires(inputFile);
        if (FeatureHandler.FEATURE_GET_MANHATTAN_DISTANCE) {
            calculateManhattanDistance();
        }


        return result;
    }

    private void findCrossoverPoints() {
        wireOne.retainAll(wireTwo); // keeps only what both have
        System.out.println(wireOne.toString());
    }

    private void calculateManhattanDistance() {
        getAllCoordinatesWireCovers();
        findCrossoverPoints();
        System.out.println(wireOne.toString());
    }

    private void getAllCoordinatesWireCovers() {
        int xInt = 0;
        int yInt = 0;
        int wireNumber = 1;
        for (List<String> wire : allWires) {
            for (String movement : wire) {
                char directionHeaded = movement.charAt(0);
                int numberOfSteps = Integer.parseInt(movement.substring(1));
                for (int i = 0; i < numberOfSteps; i++) {
                    switch (directionHeaded) {
                        case 'R':
                            xInt += 1;
                            break;
                        case 'L':
                            xInt -= 1;
                            break;
                        case 'U':
                            yInt += 1;
                            break;
                        case 'D':
                            yInt -= 1;
                            break;
                        default:
                            System.out.println("Error");
                    }
                    if (wireNumber == 1) {
                        wireOne.add("X" + xInt + "Y" + yInt);
                    } else {
                        wireTwo.add("X" + xInt + "Y" + yInt);
                    }
                }
            }
            wireNumber++;
            xInt = 0;
            yInt = 0;
        }

    }
}