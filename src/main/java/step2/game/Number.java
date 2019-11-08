package step2.game;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static step2.game.LottoGame.MAX_NUMBER;
import static step2.game.LottoGame.MIN_NUMBER;

public class Number {
    private static final String NUMBER_RANGE_EXCEPTION = "로또번호는 1 ~ 45 사이의 숫자입니다.";
    private static final Map<Integer, Number> verifiedNumbers
            = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed()
            .collect(toMap(number -> number, number -> new Number(number)));

    Integer num;

    private Number(Integer num) {
        this.num = num;
    }

    public static Number verifyOf(int number) {
        if (verifiedNumbers.containsKey(number)) {
            return verifiedNumbers.get(number);
        }

        throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
    }
}
