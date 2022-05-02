package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int SAME_FIVE_NUMBERS = 5;
    private static final int SAME_BONUS_NUMBER = 1;
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
        int sameLottoNumberCount = Math.toIntExact(this.lottoNumbers
                .stream()
                .filter(lotto.lottoNumbers::contains)
                .count());
        int sameBonusCount = Math.toIntExact(this.lottoNumbers
                .stream()
                .filter(lottoNumber -> lottoNumber.getLottoNumber() == bonus)
                .count());

        return sameLottoNumberCount == SAME_FIVE_NUMBERS && sameBonusCount == SAME_BONUS_NUMBER;
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
