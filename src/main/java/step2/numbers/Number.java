package step2.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static step2.numbers.LottoGame.MAX_NUMBER;
import static step2.numbers.LottoGame.MIN_NUMBER;

public class Number {
    private static final Map<Integer, Number> verifiedNumbers
            = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(toMap(number -> number, Number :: new));
    private static final String NUMBER_RANGE_EXCEPTION = "로또번호는 1 ~ 45 사이의 숫자입니다.";
    private final Integer num;

    private Number(Integer num) {
        this.num = num;
    }

    public static Number valueOf(int number) {
        if ( verifiedNumbers.containsKey(number) ) {
            return verifiedNumbers.get(number);
        }

        throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
    }

    public static List<Number> createVerifiedNumbers() {
        return new ArrayList<>(Number.verifiedNumbers.values());
    }

    public static int compareTo(Number number1, Number number2) {
        return Integer.compare(number1.num, number2.num);
    }

    @Override
    public String toString() {
        return num.toString();
    }

}
