package calculator.domain;

public class StringCalculator {

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String inputText) {
        return sum(new InputText(inputText).splitInputText());
    }

    private static int sum(String[] splitNums) {
        SplitTextNum splitTextNum = new SplitTextNum(splitNums);
        return splitTextNum.sum();
    }
}
