package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private final List<LottoNo> numbers = new ArrayList<>();

    public LottoNumbers() {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .forEach(i -> numbers.add(new LottoNo(i)));
    }

    public List<LottoNo> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public static void validate(Set<LottoNo> numbers) {
        if (numbers.stream().anyMatch(number -> !isNumberValid(number))) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_START_NUMBER + "부터 " + LOTTO_END_NUMBER + "사이여야 합니다.");
        }
    }

    private static boolean isNumberValid(LottoNo number) {
        return number.isValid();
    }

}
