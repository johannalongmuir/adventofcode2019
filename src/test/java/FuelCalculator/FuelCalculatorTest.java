package FuelCalculator;

import mainapp.FeatureHandler;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FuelCalculatorTest {

    private String inputNumber;
    private String result;


    @Test
    public void InvalidNumberReturned() {
        givenAllFeaturesStartOff();
        givenInputOf("-5");
        whenRunFuelCalculator();
        thenResultIs("Invalid Number");
    }

    @Test
    public void TwelveReturnsTwo() {
        givenAllFeaturesStartOff();
        givenInputOf("12");
        whenRunFuelCalculator();
        thenResultIs("2");
    }

    @Test
    public void resultsOfEachNumberSumTogetherForResult() {
        givenAllFeaturesStartOff();
        givenInputOf("70219\n" + "93253\n" + "79077\n" + "75104\n" + "142278\n");
        whenRunFuelCalculator();
        thenResultIs("153299");
    }

    @Test
    public void whenGivenRequirementToIncludeFuelForMassOfFuel() {
        givenAllFeaturesStartOff();
        givenFeatureMassOfFuelWeightOn();
        givenInputOf("70219");
        whenRunFuelCalculator();
        thenResultIs("35077");
    }

    @Test
    public void includeFuelForMassOfFuelNotBelow0() {
        givenAllFeaturesStartOff();
        givenFeatureMassOfFuelWeightOn();
        givenInputOf("14");
        whenRunFuelCalculator();
        thenResultIs("2");
    }

    private void givenInputOf(String input) {
        inputNumber = input;
    }

    private void givenAllFeaturesStartOff() {
        FeatureHandler.FEATURE_MASS_OF_FUEL_WEIGHT = false;
    }

    private void givenFeatureMassOfFuelWeightOn() {
        FeatureHandler.FEATURE_MASS_OF_FUEL_WEIGHT = true;
    }


    private void whenRunFuelCalculator() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        result = fuelCalculator.run(inputNumber);
    }


    private void thenResultIs(String returns) {
        Assertions.assertThat(result).isEqualTo(returns);
    }

}