package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final String EXCEP_INVALID_NUM = "로또 번호로 유효하지 않습니다.";
    private final List<Integer> lotto;

    Lotto(List<Integer> lottoNums) {
        checkValidLotto(lottoNums);

        this.lotto = lottoNums;
    }

    void checkValidLotto(List<Integer> lottoNums) {
        for (Integer num : lottoNums) {
            checkValidNum(num);
        }
    }

    void checkValidNum(int num) {
        if (num <= 0 || num > LottoMachine.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(EXCEP_INVALID_NUM + " : " + num);
        }
    }

    public List<Integer> getLottoNums() {
        return lotto;
    }

    int countMatchingNums(List<Integer> winningNums) {
        int count = 0;

        for (Integer num : winningNums) {
            count += lotto.contains(num) ? 1 : 0;
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
