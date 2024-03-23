package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Rule {

    NUMBERS_OF_BALLS(6), //한 게임당 추첨할 볼의 개수
    MAX_NUMBER(45),      //볼의 최대 숫자
    MIN_NUMBER(1),       //볼의 최소 숫자
    LOTTO_PRICE(1000);   //로또당 가격

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER.value, MAX_NUMBER.value)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, NUMBERS_OF_BALLS.value);
    }

    public static boolean isNotPaymentSufficientForLotto(int payment) {
        return payment < LOTTO_PRICE.value;
    }

    public static boolean isNotInRange(int number) {
        return !(number >= MIN_NUMBER.value && number <= MAX_NUMBER.value);
    }

    public static String formatGreaterThanLottoPrice() {
        return String.format("구입 금액은 %d원 이상이어야 합니다.", Rule.LOTTO_PRICE.value);
    }

    public int getValue() {
        return value;
    }

}
