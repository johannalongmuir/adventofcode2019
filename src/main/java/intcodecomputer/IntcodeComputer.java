package intcodecomputer;

import mainapp.FeatureHandler;
import mainapp.ImplimentRunner;
import mainapp.SplitInput;

import java.util.List;

public class IntcodeComputer implements ImplimentRunner {

    private static final int NOUN_ADDRESS_ONE = 1;
    private static final int VERB_ADDRESS_TWO = 2;
    private List<Integer> intcodeList;

    @Override
    public String run(String inputFile) {
       intcodeList = SplitInput.splitInputByCommar(inputFile);
       intcodeComputer();
       return intcodeList.get(0).toString();
    }

    protected void intcodeComputer(){
        if (FeatureHandler.FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202){
            restoreGravityAssistProgramWith1202();
            runIntcode();
        }
        if (FeatureHandler.FEATURE_FIND_NOUN_VERB_INPUT_FOR_ADDRESS_ZERO){

        }

    }

    private void runIntcode() {
        for (int instructionPointer = 0; instructionPointer < intcodeList.size() ; instructionPointer += 4) {
            if (intcodeList.get(instructionPointer) == 99) {
                break;
            } else if (intcodeList.get(instructionPointer) == 1 || intcodeList.get(instructionPointer) == 2) {
                int addressOne = intcodeList.get(instructionPointer + NOUN_ADDRESS_ONE);
                int addressTwo = intcodeList.get(instructionPointer + VERB_ADDRESS_TWO);
                int replaceAt = intcodeList.get(instructionPointer + 3);
                int sum;
                if (intcodeList.get(instructionPointer) == 1) {
                    sum = intcodeList.get(addressOne) + intcodeList.get(addressTwo);
                    intcodeList.set(replaceAt, sum);
                } else if (intcodeList.get(instructionPointer) == 2) {
                    sum = intcodeList.get(addressOne) * intcodeList.get(addressTwo);
                    intcodeList.set(replaceAt, sum);
                }
            } else {
                System.out.println("Invalid Opcode at pointer " + instructionPointer);
                break;
            }
        }
    }


    protected void restoreGravityAssistProgramWith1202() {
        intcodeList.set(NOUN_ADDRESS_ONE, 12);
        intcodeList.set(VERB_ADDRESS_TWO, 2);
    }


//    protected void gravityAssistOutputConvertToInputs(int resultAt0) {
//        int maximumValue = 99;
//        entryLoop: for (int noun = 0; noun <= maximumValue; noun++) {
//
//            for (int verb = 0; verb <= maximumValue; verb++) {
//                intcodeList.set(NOUN_ADDRESS_ONE, noun);
//                intcodeList.set(VERB_ADDRESS_TWO, verb);
//                runIntcode();
//
//                if (intcodeList.get(0) == resultAt0) {
//                    System.out.println(intcodeList.get(NOUN_ADDRESS_ONE));
//                    System.out.println(intcodeList.get(VERB_ADDRESS_TWO));
//                    break entryLoop;
//                } else {
//                    intcodeList.clear();
//                    //resetIntcodeInput();
//                }
//            }
//        }
//    }
//


//    private void resetIntcodeInput () {
//        intcodeList.clear();
//        splitInput(initialState);
//    }
}
