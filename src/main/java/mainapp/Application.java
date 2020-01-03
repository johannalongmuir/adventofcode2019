package mainapp;

import crossedwires.CrossedWires;
import intcodecomputer.IntcodeComputer;
import mainapp.userInterface.UserInterface;

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
            UserInterface.userInputNeeded(file, scanner);
            scanner.close();
        } else {
            String inputFile = file.importFile(File.DAY_2);
            ImplimentRunner implimentRunner = new IntcodeComputer();
            System.out.println(implimentRunner.run(inputFile));
        }
    }


}
