package crossedwires;

import drawdirections.DrawDirections;
import mainapp.FeatureHandler;
import mainapp.ImplimentRunner;
import mainapp.SplitInput;
import java.util.*;

public class CrossedWires implements ImplimentRunner {
    List<List<String>> allWires = new ArrayList<>();
    Map<String, Integer> wireOne = new HashMap<>();
    Map<String, Integer> wireTwo = new HashMap<>();
    HashSet<String> duplicates;
    Integer manhattanDistance = Integer.MAX_VALUE;
    Integer minimumNumberOfSteps = Integer.MAX_VALUE;
    String result = "";


    @Override
    public String run(String inputFile) {
        allWires = SplitInput.splitCrossedWires(inputFile);
        calculateDistance();
        return result;
    }



    private void calculateDistance() {
        getAllCoordinatesWires();
        findAllCrossoverPoints();
        if (FeatureHandler.FEATURE_LOWEST_NUMBER_OF_STEPS_TO_CROSSED_WIRE){
            lowestNumberOfSteps();
        } else {
            calculateManhattan();
        }
//        if (true){
//            DrawDirections drawDirections = new DrawDirections();
//            drawDirections.drawWires(wireOne,wireTwo,duplicates);
//        }
    }

    private void findAllCrossoverPoints() {
        duplicates = new HashSet<>(wireOne.keySet());
        duplicates.retainAll(wireTwo.keySet());
    }

    private void calculateManhattan() {
        for (String location: duplicates) {
            String[] xAndYCoordinates = location.split(":");
            int xAxis = Math.abs(Integer.parseInt(xAndYCoordinates[0]));
            int yAxis = Math.abs(Integer.parseInt(xAndYCoordinates[1]));
            if (xAxis + yAxis < manhattanDistance) {
                manhattanDistance = xAxis + yAxis;
            }
            result = "Manhattan Distance (Closest to 0,0): " + manhattanDistance;
        }
    }

    private void lowestNumberOfSteps() {
        for (String duplicate : duplicates) {
            Integer stepsWireOne = wireOne.get(duplicate);
            Integer stepsWireTwo = wireTwo.get(duplicate);
            int totalSteps = stepsWireOne + stepsWireTwo;
            if (totalSteps < minimumNumberOfSteps){
                minimumNumberOfSteps = totalSteps;
            }
        }
        result = "Lowest steps to crossed wire: " + minimumNumberOfSteps;
    }


    private void getAllCoordinatesWires() {
        int xInt = 0;
        int yInt = 0;
        int wireNumber = 1;
        for (List<String> wire : allWires) {
            int steps = 0;
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
                    ++steps;
                    if (wireNumber == 1) {
                        wireOne.put(xInt + ":" + yInt, steps);
                    } else {
                        wireTwo.put(xInt + ":" + yInt, steps);
                    }
                }
            }
            wireNumber++;
            xInt = 0;
            yInt = 0;
        }
    }
}