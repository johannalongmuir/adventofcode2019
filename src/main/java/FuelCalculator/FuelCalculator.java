package FuelCalculator;

import mainapp.ImplimentRunner;
import mainapp.SplitInput;
import static mainapp.FeatureHandler.FEATURE_MASS_OF_FUEL_WEIGHT;

public class FuelCalculator implements ImplimentRunner {
    private Integer fuelCounterUpper = 0;
    private String result;

    @Override
    public String run(String inputFile) {
        calculateMass(SplitInput.splitInputByLine(inputFile));
        return result;
    }



    private void calculateMass(String[] masses) {
        for (String mass : masses) {
            int massNumber = Integer.parseInt(mass);
            if (massNumber > 0) {
                int calculatedFuelByMass = fuelByMassCalculator(massNumber);
                fuelCounterUpper += calculatedFuelByMass;

                if (FEATURE_MASS_OF_FUEL_WEIGHT) {
                    while (calculatedFuelByMass > 0) {
                        calculatedFuelByMass = fuelByMassCalculator(calculatedFuelByMass);
                        if (calculatedFuelByMass > 0) {
                            fuelCounterUpper += calculatedFuelByMass;
                        } else {
                            calculatedFuelByMass = 0;
                        }
                    }
                }
                result = fuelCounterUpper.toString();
            } else {
                result = "Invalid Number";
            }
        }
    }


    private static Integer fuelByMassCalculator(int mass) {
        return (mass / 3) - 2;
    }

}
