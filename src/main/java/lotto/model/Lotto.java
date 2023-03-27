package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_SIX_HIT = 6;
    private static final int LOTTO_FIVE_HIT = 5;
    private static final int LOTTO_TWO_HIT = 2;

    private List<LottoNumber> lottoNumbers;

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개 이여야 함");
        }

        if (lottoNumbers.stream().distinct().count() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복 번호 존재");
        }

        Collections.sort(lottoNumbers, (a, b) -> a.getValue() - b.getValue());
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int match(WinningLotto winningLotto) {

        int hitCount = (int) lottoNumbers.stream()
                .filter(it -> winningLotto.getLotto().getLottoNumbers().contains(it))
                .count();

        if (hitCount == LOTTO_SIX_HIT) {
            return 1;
        }

        boolean hitBonus = lottoNumbers.contains(winningLotto.getBonusNumber());
        if (hitCount == LOTTO_FIVE_HIT && hitBonus) {
            return 2;
        }

        if (hitCount > LOTTO_TWO_HIT) {
            return 6 - hitCount + 2;
        }

        return 0;
    }
}
