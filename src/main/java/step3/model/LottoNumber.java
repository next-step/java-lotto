package step3.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public List<Integer> getNumber() {
        Collections.shuffle(this.numbers);
        return this.numbers.subList(0, 6);
    }

    public boolean isOverMaxNumber(int number) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자가 아닙니다.");
        }

        return false;
    }
}
