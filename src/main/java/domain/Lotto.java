package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int SAME_FIVE_NUMBERS_AND_BONUS = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 6개로 입력 하셔야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> compareSameNumberList(Lotto lotto) {
        return this.lottoNumbers
                .stream()
                .filter(lotto.lottoNumbers::contains)
                .collect(Collectors.toList());
    }

    public boolean sameFiveNumberListWithBonusNumber(Lotto lotto, int bonus) {
        Set<LottoNumber> checkLotto = new HashSet<>(lotto.lottoNumbers);
        checkLotto.add(new LottoNumber(bonus));

        int sameLottoNumberCount = (int) checkLotto.stream()
            .filter(lottoNumbers::contains)
            .count();

        return sameLottoNumberCount == SAME_FIVE_NUMBERS_AND_BONUS;
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
