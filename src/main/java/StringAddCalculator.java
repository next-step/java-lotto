public class StringAddCalculator {
    public static int splitAndSum(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return 0;
        }

        String[] splitInputData = inputData.split(",|:");
        int result = 0;

        for (int i = 0; i < splitInputData.length; i++) {
            result = result + Integer.parseInt(splitInputData[i]);
        }
        return result;
    }
}
