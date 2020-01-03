package mainapp;

public class FeatureHandler {

    // TODO add features from playground if want.
    static boolean SCANNER_INPUT_ON = false;
    public static boolean FEATURE_MASS_OF_FUEL_WEIGHT = false;
    public static boolean FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202 = true;
    public static boolean FEATURE_FIND_NOUN_VERB_INPUT_FOR_ADDRESS_ZERO = false;
    public static boolean FEATURE_GET_MANHATTAN_DISTANCE = true;
    public static boolean NUMBER_OF_STEPS_TO_MANHATTAN = true;

    public static void setScannerInputOn(boolean scannerInputOn) {
        SCANNER_INPUT_ON = scannerInputOn;
    }

    public static void setFeatureMassOfFuelWeight(boolean featureMassOfFuelWeight) {
        FEATURE_MASS_OF_FUEL_WEIGHT = featureMassOfFuelWeight;
    }

    public static void setFeatureRestoreGravityAssistProgram1202(boolean featureRestoreGravityAssistProgram1202) {
        FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202 = featureRestoreGravityAssistProgram1202;
    }

    public static void setFeatureFindNounVerbInputForAddressZero(boolean featureFindNounVerbInputForAddressZero) {
        FEATURE_FIND_NOUN_VERB_INPUT_FOR_ADDRESS_ZERO = featureFindNounVerbInputForAddressZero;
    }
}
