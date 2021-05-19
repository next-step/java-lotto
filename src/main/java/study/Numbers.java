package study;

import java.util.ArrayList;

public class Numbers {
    private static final String MATCH_NUMBER = "^[0-9]+$";
    private static final String EXCEPTION_MESSAGE = "음수 또는 정수 이외의 값은 더할 수 없습니다.";

    private ArrayList<Integer> numbers = new ArrayList<>();

    public  Numbers(String[] numberList) {
        for (int i = 0; i < numberList.length; i++) {
            validateNumberList(numberList[i]);
            this.numbers.add(Integer.parseInt(numberList[i]));
        }
    }

    public void validateNumberList(String number) {
        if (!number.matches(MATCH_NUMBER)) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
}
