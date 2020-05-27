package study.calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(String[] strings) {
        if(strings == null) {
            throw new RuntimeException();
        }

        numbers = createNumbers(strings);
    }

    private List<Integer> createNumbers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();

        for(String str : strings) {
            numbers.add(getIntFromString(str));
        }

        // numbers = Arrays.stream(strings).map(this::getIntFromString).collect(Collectors.toList());

        return numbers;
    }

    private int getIntFromString(String str) throws RuntimeException {
        int number = Integer.parseInt(str);

        if(number < 0) {
            throw new RuntimeException("음수는 입력 불가능 합니다.");
        }

        return number;
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
