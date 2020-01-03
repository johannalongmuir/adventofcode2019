package intcodecomputer;

import mainapp.FeatureHandler;
import mainapp.ImplimentRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IntcodeComputerTest {

    private String inputCode;
    private String result;
    ImplimentRunner mock = new IntcodeComputer();

//    @Test
//    public void invalidIntCode() {
//        givenAllFeaturesStartOff();
//        givenInputOf("10,0,0,0");
//        whenRunIntcodeComputer();
//        //TODO check how to confirm exception/sout is run?
//        thenResultAtAdressZeroIs("10");
//    }

    @Test
    public void basicIntcodeProgram() {
        givenAllFeaturesStartOff();
        givenInputOf("1,9,10,3,2,3,11,0,99,30,40,50");
        whenRunIntcodeComputer();
        thenResultAtAdressZeroIs("3500");
    }


    @Test
    public void gravityAssistProgramOn() {
        givenAllFeaturesStartOff();
        givenGravityAssistProgramOn();
        givenInputOf("1,0,0,0,99,0,0,8,1,0,0,9,2,0,0,5,99,40,50,60");
        whenRunIntcodeComputer();
        thenResultAtAdressZeroIs("4");
    }

//    @Test
//    public void findNounAndVerbForResultAtAddressOne() {
//        givenAllFeaturesStartOff();
//        givenFindNounVerbInputForAddressZeroIsOn();
//        givenInputOf("1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,6,19,23,2,6,23,27,1,5,27,31,2,31,9,35,1,35,5,39,1,39,5,43,1,43,10,47,2,6,47,51,1,51,5,55,2,55,6,59,1,5,59,63,2,63,6,67,1,5,67,71,1,71,6,75,2,75,10,79,1,79,5,83,2,83,6,87,1,87,5,91,2,9,91,95,1,95,6,99,2,9,99,103,2,9,103,107,1,5,107,111,1,111,5,115,1,115,13,119,1,13,119,123,2,6,123,127,1,5,127,131,1,9,131,135,1,135,9,139,2,139,6,143,1,143,5,147,2,147,6,151,1,5,151,155,2,6,155,159,1,159,2,163,1,9,163,0,99,2,0,14,0");
//        whenRunIntcodeComputer();
//        thenResultAtAdressOneIs("23");
//        thenResultAtAdressTwoIs("47");
//        thenResultAtAdressZeroIs("19690720");
//    }
//
//    private void thenResultAtAdressTwoIs(String s) {
//        //TODO Mock? Need to access private.
//    }
//
//    private void thenResultAtAdressOneIs(String s) {
//        //TODO Mock? Need to access private.
//    }

    private void givenAllFeaturesStartOff() {
        FeatureHandler.setFeatureFindNounVerbInputForAddressZero(false);
        FeatureHandler.setFeatureRestoreGravityAssistProgram1202(false);
    }

    private void givenGravityAssistProgramOn() {
        FeatureHandler.setFeatureRestoreGravityAssistProgram1202(true);
    }

    private void givenFindNounVerbInputForAddressZeroIsOn() {
        FeatureHandler.setFeatureFindNounVerbInputForAddressZero(true);
    }

    private void givenInputOf(String input) {
        inputCode = input;
    }

    private void whenRunIntcodeComputer() {
        result = mock.run(inputCode);
    }

    private void thenResultAtAdressZeroIs(String output) {
        Assertions.assertThat(result).isEqualTo(output);
    }
}