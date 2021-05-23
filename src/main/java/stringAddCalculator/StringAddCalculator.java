package stringAddCalculator;

import java.util.List;

public class StringAddCalculator {
    private static InputHandler inputHandler = new InputHandler();
    private static Divider divider = new Divider();

    public static int splitAndSum(String input) {
        if (inputHandler.isEmptyInput(input)) return 0;
        String targetNum = input;
        List<String> splitInputs = divider.getSplitByCustomDelimiter(input);
        if (splitInputs.size() > 1) {
            divider.setCustomDelimiter(splitInputs.get(0));
            targetNum = splitInputs.get(1);
        }
        String[] numArray = divider.getDividedInput(targetNum);
        return stringAdd(numArray);
    }

    private static int stringAdd(String[] numArray) {
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            inputHandler.illegalInputFilter(numArray[i]);
            sum += Integer.parseInt(numArray[i]);
        }
        return sum;
    }
}
