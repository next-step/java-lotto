package lotto;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lotto; // todo) Integer -> LottoNumber로 변경하기
    private static final int LOTTO_MAXIMUM_VALUE = 45;
    private static final int LOTTO_MINIMUM_VALUE = 1;

    public Lotto(List<Integer> lotto) {
        isRangeIn(lotto);
        checkDuplicate(lotto);
        this.lotto = lotto;
    }

    private void checkDuplicate(List<Integer> lotto) {
        Set<Integer> setLottoNumbers = new HashSet<>(lotto);
        if (setLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

    private void isRangeIn(List<Integer> lotto) {
        lotto.stream()
                .filter(number -> isBetweenValid(number))
                .findAny()
                .ifPresent(a -> {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
                });
    }

    private boolean isBetweenValid(int number) {
        return number < LOTTO_MINIMUM_VALUE || number > LOTTO_MINIMUM_VALUE;
    }
}
