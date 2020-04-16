package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }
    public static Object of(List<Integer> lottoNumbers) {
        checkDuplicatedNumber(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void checkDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

}
