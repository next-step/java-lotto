package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> lotto; // todo) Integer -> LottoNumber로 변경하기

    public Lotto(List<Integer> lotto) {
        checkDuplicate(lotto);
        this.lotto = lotto;
    }

    private void checkDuplicate(List<Integer> lotto) {
        Set<Integer> setLottoNumbers = new HashSet<>(lotto);
        if (setLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

}
