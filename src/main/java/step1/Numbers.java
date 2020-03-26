package step1;

public class Numbers {

    static final int INIT_VALUE = 0;

    private String[] numberStrings;

    public Numbers(String[] numberStrings) {
        this.numberStrings = numberStrings;
    }

    public int addAll() {
        int result = INIT_VALUE;

        for(String numberString : numberStrings) {
            int number = stringToInteger(numberString);
            result = result + number;
        }

        return result;
    }

    private static Integer stringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
