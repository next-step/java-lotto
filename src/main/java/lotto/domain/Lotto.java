package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto implements Comparable<Lotto> {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void validateLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
        if (isOutOfBoundLotto(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 여야 합니다.");
        }
    }

    private static boolean isOutOfBoundLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(number -> number > LOTTO_END_NUMBER || number < LOTTO_START_NUMBER);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) object;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static int addResult(List<Integer> winner, Integer lottoNumber) {
        if (winner.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }


    @Override
    public int compareTo(Lotto winner) {
        int result = 0;
        for (Integer lottoNumber : lottoNumbers) {
            result += addResult(winner.getLottoNumbers(), lottoNumber);
        }
        return result;
    }
}
