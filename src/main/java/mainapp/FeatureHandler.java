package mainapp;

public class FeatureHandler {

    // TODO add features from playground if want.
    static boolean SCANNER_INPUT_ON = false;
    public static boolean FEATURE_MASS_OF_FUEL_WEIGHT = true;
    public static boolean FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202 = false;
    public static boolean FEATURE_FIND_NOUN_VERB_INPUT_FOR_ADDRESS_ZERO = false;




    static void setScannerInputOn(boolean scannerInputOn) {
        SCANNER_INPUT_ON = scannerInputOn;
    }

    static void setFeatureMassOfFuelWeight(boolean featureMassOfFuelWeight) {
        FEATURE_MASS_OF_FUEL_WEIGHT = featureMassOfFuelWeight;
    }

    public static void setFeatureRestoreGravityAssistProgram1202(boolean featureRestoreGravityAssistProgram1202) {
        FEATURE_RESTORE_GRAVITY_ASSIST_PROGRAM1202 = featureRestoreGravityAssistProgram1202;
    }
}
