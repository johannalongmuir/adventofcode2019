package intcodecomputer;

import mainapp.FeatureHandler;
import mainapp.ImplimentRunner;
import mainapp.SplitInput;

import java.util.ArrayList;
import java.util.List;

public class IntcodeComputer implements ImplimentRunner {

    private static final int NOUN_ADDRESS_ONE = 1;
    private static final int VERB_ADDRESS_TWO = 2;
    private int nounValueFoundForAddressZero;
    private int verbValueFoundForAddressZero;
    protected int GRAVITY_ASSIST_OUTPUT_ADDRESS_0 = 19690720;
    private List<Integer> intcodeList;
    private List<Integer> initialcode;


    @Override
    public String run(String inputFile) {
       intcodeList = SplitInput.splitInputByCommarNumbersOnly(inputFile);
       intcodeComputer();
       return intcodeList.get(0).toString();
    }

    protected void intcodeComputer(){
        if (FeatureHandler.FEATURE_FIND_NOUN_VERB_INPUT_FOR_ADDRESS_ZERO) {
            findNounAndVerbForResultAtAddressOne(GRAVITY_ASSIST_OUTPUT_ADDRESS_0);
            System.out.println("Noun is " + nounValueFoundForAddressZero);
            System.out.println("Verb is " + verbValueFoundForAddressZero);
        } else {
            if (FeatureHandler.FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202) {
                restoreGravityAssistProgramWith1202();
            }
            runIntcode();
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
                    sum = (intcodeList.get(addressOne)) + (intcodeList.get(addressTwo));
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


    protected void findNounAndVerbForResultAtAddressOne(int resultAt0) {
        int maximumValue = 99;
        setUpRestoreIntcode();
        entryLoop: for (int noun = 0; noun <= maximumValue; noun++) {
            for (int verb = 0; verb <= maximumValue; verb++) {
                intcodeList.set(NOUN_ADDRESS_ONE, noun);
                intcodeList.set(VERB_ADDRESS_TWO, verb);
                runIntcode();
                if (intcodeList.get(0) == resultAt0) {
                    nounValueFoundForAddressZero = intcodeList.get(NOUN_ADDRESS_ONE);
                    verbValueFoundForAddressZero = intcodeList.get(VERB_ADDRESS_TWO);
                    break entryLoop;
                } else {
                    intcodeList.clear();
                    restoreIntcodeInput();
                }
            }
        }
    }


    private void setUpRestoreIntcode() {
        initialcode = new ArrayList<>(intcodeList);
    }

    private void restoreIntcodeInput() {
        intcodeList.clear();
        intcodeList = new ArrayList<>(initialcode);
    }

    public List<Integer> getIntcodeList() {
        return intcodeList;
    }
}
