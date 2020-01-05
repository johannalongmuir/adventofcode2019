package drawdirections;

import crossedwires.CrossedWires;
import mainapp.ImplimentRunner;
import mainapp.SplitInput;

import java.util.*;

public class DrawDirections implements ImplimentRunner {
    List<List<String>> allWires;
    Map<String, Integer> wireOne = new HashMap<>();
    Map<String, Integer> wireTwo = new HashMap<>();
    HashSet<String> duplicates;




    @Override
    public String run(String inputFile) {
        allWires = SplitInput.splitCrossedWires(inputFile);
        getAllCoordinatesDrawWires();
        findAllCrossoverPoints();
        drawWires(wireOne, wireTwo, duplicates);

        //Testing this. Have copied code from CrossedWires...
//        plotDirection();
//        maxYSizeCheck();
//        addEmptyPositionValues();
//
//        if (FeatureHandler.FEATURE_NO_PRINT_PERIODS) {
//            removePeriodsInAllArrays();
//        }
//        if (FeatureHandler.FEATURE_PRINT_GRID) {
//            printPositionOnGrid();
//        }
        return null;

        /*
        Set up the user interface so that you can add your own directions in?
        scanner.nextLine wire one: R3,D3,R3:
        scanner.nextLine wire two: D3,R2:
        Takes out any spaces + input is wireOne /n + wireTwo? or select to be given wired directions seperatly which maybe better

        drawDirections(wireOne, wireTwo)
        are you ready to print Y/N?
        if N - add directions or give new directions.
        if add directions, select which wire you want to add to
            1: wire One
            2: wire Two
        Then based on what pick, prints out
        Please update wire one
        WireOne: R3,D3,R3,
        .

        PrintsOut
        Asks if you want to add more directions, give new directions/clear or exit?
        If yes will add to the end of what already have in wire One or Two.

        Then can reprint whole thing
        Can also clear to start over?

         */
    }


    // do we want this?
    public void drawWires(Map<String, Integer> wireOne, Map<String, Integer> wireTwo, HashSet<String> duplicates) {
        // when coordinates of array set up
        // setCoordinates(Map wire, String replaceWith)
        // get wire xAxis, yAxis
        // checkIfpositionExistsOnArray
        // if no add the positions
        // change x,y to replaceWith
        // e.g wireOne, "." and wireTwo "*"
        // print arrays out.


        for (String location : duplicates) {
            String[] split = location.split(":");
            int xAxis = Integer.parseInt(split[0]);
            int yAxis = Integer.parseInt(split[1]);

            // when coordinates array of array set up.
            // coordinates.get(xAxis).set(yAxis, "X");

        }
    }


    private void getAllCoordinatesDrawWires() {
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

    private void findAllCrossoverPoints() {
        duplicates = new HashSet<>(wireOne.keySet());
        duplicates.retainAll(wireTwo.keySet());
    }
}
