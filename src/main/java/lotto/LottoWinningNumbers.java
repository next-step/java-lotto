package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final static int FIVE_LOTTO_MATCH = 5;
    private final Lotto lottoWinningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lottoWinningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto lotto, LottoNumber lottoNumber) {
        lotto.validate(lotto.lottoNumbers());
        lottoNumber.validate(lottoNumber.lottoNumber());

        checkLottoSizeIsValid(lotto);
    }

    private void checkLottoSizeIsValid(Lotto lotto) {
        if (lotto == null || lotto.lottoNumbers().isEmpty()) {
            throw new IllegalArgumentException("로또 번호가 존재해야 합니다");
        }
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
        boolean isBonus = isBonus(matchCount, lottoList);
        LottoMatch.Match match = LottoMatch.Match.from(matchCount, isBonus);
        return LottoMatch.fromMatch(match);
    }

    private boolean isBonus(int matchCount, List<LottoNumber> lottolist) {
        return matchCount == FIVE_LOTTO_MATCH && lottolist.contains(bonusNumber);
    }
}
