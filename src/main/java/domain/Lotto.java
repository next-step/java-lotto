package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int RANGE_FROM = 1;
    private static final int RANGE_TO = 45;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (validateLottoNumbers(lottoNumbers) != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 사이에 있는 값만 허용 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    private long validateLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(i -> i >= RANGE_FROM && i <= RANGE_TO)
                .count();
    }

    public List<Integer> compare(Lotto lotto) {
        return this.lottoNumbers
                .stream()
                .filter(lotto.lottoNumbers::contains)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
