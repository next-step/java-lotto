package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final Lotto lottoWinningNumbers;

    public LottoWinningNumbers(Lotto lotto) {
        validate(lotto);
        this.lottoWinningNumbers = lotto;
    }

    public void validate(Lotto lotto) {
        lotto.validate(lotto.lottoNumbers());

        checkLottoSizeIsValid(lotto);
    }

    private void checkLottoSizeIsValid(Lotto lotto) {
        if (lotto == null || lotto.lottoNumbers().isEmpty()) {
            throw new IllegalArgumentException("로또 번호가 존재해야 합니다");
        }
    }

    public boolean isSame(Lotto lotto) {
        return this.lottoWinningNumbers.equals(lotto);
    }

    public long amount(Lotto lotto) {
        LottoMatch lottoMatch = matchesLotto(lotto);
        return lottoMatch.amount();
    }

    public LottoMatch matchesLotto(Lotto lotto) {
        List<LottoNumber> lottoWinningList = new ArrayList<>(lottoWinningNumbers.lottoNumbers());
        List<LottoNumber> lottoList = new ArrayList<>(lotto.lottoNumbers());

        lottoWinningList.retainAll(lottoList);
        int matchCount = lottoWinningList.size();
        return LottoMatch.fromInt(matchCount);
    }
}
