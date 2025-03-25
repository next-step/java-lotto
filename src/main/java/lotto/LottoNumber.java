package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final List<Integer> NUM_RANGE = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    private void validateNumber(int number) {
        if (!NUM_RANGE.contains(number)) throw new IllegalArgumentException("로또 번호의 범위를 넘어선 값으로 생성할 수 없습니다.");
    }
}
