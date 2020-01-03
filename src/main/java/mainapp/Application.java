package mainapp;

import FuelCalculator.FuelCalculator;
import intcodecomputer.IntcodeComputer;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        File file = new File();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to input? Y/N");
        String initial = scanner.nextLine();
        FeatureHandler.setScannerInputOn(initial.equalsIgnoreCase("Y"));

        if (FeatureHandler.SCANNER_INPUT_ON) {
            userInputNeeded(file, scanner);
            scanner.close();
        } else {
            String inputFile = file.importFile(File.DAY_2);
            ImplimentRunner implimentRunner = new IntcodeComputer();
            System.out.println(implimentRunner.run(inputFile));
        }
    }



    private static void userInputNeeded(File file, Scanner scanner) throws IOException {
        String userInput;
        do {
            System.out.println("\nWhat do you want to do: \n" +
                    "  1 = Calculate Fuel Requirements \n" +
                    "  2 = Operate Intcode Computer \n" +
                    "  E = Exit");
            userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                runFuelCalculations(file, scanner);
            }
            if (userInput.equals("2")) {
                runIntcodeComputer(file, scanner);
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


    private static void runIntcodeComputer(File file, Scanner scanner) throws IOException {
        String fileToInput = File.DAY_2;

        System.out.println("OPERATE INTCODE COMPUTER");
        System.out.println("Do you want to reset the Gravity Assist Program? Y/N");
        boolean input = scanner.nextLine().equalsIgnoreCase("Y");
        FeatureHandler.setFeatureRestoreGravityAssistProgram1202(input);

        String inputFile = file.importFile(fileToInput);
        ImplimentRunner implimentRunner = new IntcodeComputer();
        System.out.println("Result: " + implimentRunner.run(inputFile));
    }

    private static void runFuelCalculations(File file, Scanner scanner) throws IOException {
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
