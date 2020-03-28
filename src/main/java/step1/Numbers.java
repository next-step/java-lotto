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
            checkPositiveNumber(number);

            result = result + number;
        }
        return result;
    }

    private static Integer stringToInteger(String string) {
        int integer;

        try {
            integer = Integer.parseInt(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        return integer;
    }

    private void checkPositiveNumber(int number) {
        if(number < INIT_VALUE) {
            throw new RuntimeException("숫자는 0 이상만 입력해주세요.");
        }
    }
}
