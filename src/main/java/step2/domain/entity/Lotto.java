package step2.domain.entity;

import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoType;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final int SECOND_LOTTO_COUNT = 5;

    private List<LottoNumber> lottoNumbers;
    private final LottoType lottoType;

    public Lotto(List<LottoNumber> lottoNumbers, LottoType lottoType) {
        validate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.lottoType = lottoType;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int compareWinnerLottoNumbers(List<LottoNumber> winnerLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winnerLottoNumbers::contains)
                .count();
    }

    public boolean isSecondBonusLotto(int count, LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber) && count == SECOND_LOTTO_COUNT;
    }

    public boolean isManualLotto() {
        return this.lottoType == LottoType.MANUAL;
    }

    public boolean isAutoLotto() {
        return this.lottoType == LottoType.AUTO;
    }
}
