package stringCalculator;

public class Numbers {
    private String[] numbers;

    public Numbers(String inputString) {
        createNumbers(inputString);
    }

    private void createNumbers(String inputString) {
        this.numbers =  StringUtil.complicatedSeparator(inputString);
    }

    public String[] getNumbers() {
        return numbers;
    }
}
