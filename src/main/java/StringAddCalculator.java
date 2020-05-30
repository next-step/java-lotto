public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        String[] splitText = StringUtils.splitString(text);
        int[] intArray = convertToIntArray(splitText);
        return sumIntArray(intArray);
    }

    private static int[] convertToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = convertUnsignedInt(stringArray[i]);
        }
        return intArray;
    }

    private static int convertUnsignedInt(String text) {
        int integer = Integer.parseInt(text);
        if (integer < 0) {
            throw new RuntimeException("you input negative Integer : " + text);
        }
        return integer;
    }

    private static int sumIntArray(int[] intArray) {
        int sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        return sum;
    }
}
