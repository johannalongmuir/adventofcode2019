package mainapp.userInterface;

import crossedwires.CrossedWires;
import fuelcalculator.FuelCalculator;
import intcodecomputer.IntcodeComputer;
import mainapp.FeatureHandler;
import mainapp.File;
import mainapp.ImplimentRunner;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    public static void userInputNeeded(File file, Scanner scanner) throws IOException {
        String userInput;
        do {
            System.out.println("\nMAIN\n" +
                    "What do you want to do: \n" +
                    "  1 = Calculate Fuel Requirements \n" +
                    "  2 = Operate Intcode Computer \n" +
                    "  3 = Crossed Wires \n" +
                    "  E = Exit");
            userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                runFuelCalculationsInterface(file, scanner);
            }
            if (userInput.equals("2")) {
                runIntcodeComputerInterface(file, scanner);
            }
            if (userInput.equals("3")){
                runCrossedWires(file, scanner);
            }
        }
        while (!userInput.equalsIgnoreCase("E"));

        System.out.println("_____________________________________________________ ");
        System.out.println("   ____     ____    ____         .     .    _____     ");
        System.out.println("  |    |   |       |             |     |   |     |    ");
        System.out.println("  |____    |___    |___          |_____|   |_____|    ");
        System.out.println("       |   |       |                |      |     |    ");
        System.out.println("  |____|   |____   |____            |      |     |    ");
        System.out.println("_____________________________________________________ ");
    }

    private static void runCrossedWires(File file, Scanner scanner) throws IOException {
        String fileToInput = File.DAY_3;
        System.out.println("CROSSED WIRES");
        String userInput;

        do {
            System.out.println("\nThe crossed wires are in front of you \n" +
                    "What do you want to do? \n" +
                    "  1 = Calculate the manhattan distance for the closest crossed position \n" +
                    "  2 = No Time! Find the first crossover \n" +
                    "  E = Exit and replace the panel on the wall");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("E")) {
                break;
            }
            if (userInput.equals("1")) {
                FeatureHandler.setFeatureLowestNumberOfStepsToCrossedWire(false);
            }
            if (userInput.equals("2")) {
                FeatureHandler.setFeatureLowestNumberOfStepsToCrossedWire(true);
            }
            String inputFile = file.importFile(fileToInput);
            ImplimentRunner implimentRunner = new CrossedWires();
            System.out.println("Result: " + implimentRunner.run(inputFile));
        }
        while (!userInput.equalsIgnoreCase("E"));
    }

    private static void runIntcodeComputerInterface(File file, Scanner scanner) throws IOException {
        String fileToInput = File.DAY_2;
        System.out.println("OPERATE INTCODE COMPUTER");
        String userInput;

        do {
            System.out.println("\nWhat do you want to do with the Intcode computer? \n" +
                    "  1 = Run the given Intcode Program \n" +
                    "  2 = Reset the Gravity Assist Program \n" +
                    "  3 = Find Noun and Verb for Address at Zero: 19690720 \n" +
                    "  E = Exit Intcode Computer");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("E")) {
                break;
            }
            if (userInput.equals("1")) {
                FeatureHandler.setFeatureRestoreGravityAssistProgram1202(false);
                FeatureHandler.setFeatureFindNounVerbInputForAddressZero(false);
            }
            if (userInput.equals("2")) {
                FeatureHandler.setFeatureRestoreGravityAssistProgram1202(true);
            }
            if (userInput.equals("3")) {
                FeatureHandler.setFeatureFindNounVerbInputForAddressZero(true);
            }
            String inputFile = file.importFile(fileToInput);
            ImplimentRunner implimentRunner = new IntcodeComputer();
            System.out.println("Result: " + implimentRunner.run(inputFile));
        }
        while (!userInput.equalsIgnoreCase("E"));

    }

    private static void runFuelCalculationsInterface(File file, Scanner scanner) throws IOException {
        String fileToInput = File.DAY_1;
        System.out.println("CALCULATE FUEL REQUIREMENTS");
        System.out.println("Do you want to add the calculation for fuel mass? Y/N");
        boolean input = scanner.nextLine().equalsIgnoreCase("Y");
        FeatureHandler.setFeatureMassOfFuelWeight(input);

        String inputFile = file.importFile(fileToInput);
        ImplimentRunner implimentRunner = new FuelCalculator();
        System.out.println("Result: " + implimentRunner.run(inputFile));
    }
}
