package lotto.domain.lotto;

import lotto.domain.AutoLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final String ERR_MESSAGE_RANGE = "로또 숫자 범위를 확인해주세요 (입력범위 1 ~ 45)";
    public static final int END_NUMBER = 45;
    public static final int START_NUMBER = 1;
    public static final int MARKED_RANGE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        numbers = AutoLottoNumbers.autoNumbers();
    }

    public Lotto(List<Integer> answer) {
        AutoLottoNumbers.valid(answer);
        numbers = new ArrayList<>(answer);
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }

}
