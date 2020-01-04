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
            String inputFile = file.importFile(File.DAY_3);
//            String inputFile = "R10,U4,L18,U17,R12,D1,R8,U9,R9,U1" +
//                    "\n" +
//                    "L7,U15,R12,D18";
            ImplimentRunner implimentRunner = new CrossedWires();
            System.out.println(implimentRunner.run(inputFile));
        }
    }


}
