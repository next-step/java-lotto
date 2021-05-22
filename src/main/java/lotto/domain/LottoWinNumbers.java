package lotto.domain;

import static lotto.domain.LottoGameOptions.*;

public class LottoWinNumbers {
    private LottoWinNormalNumbers normalNumbers;
    private LottoWinBonusNumber bonusNumber;

    public LottoWinNumbers(String numbers) {
        normalNumbers = new LottoWinNormalNumbers(numbers);
        bonusNumber = new LottoWinBonusNumber(0);
    }

    public LottoResultPack checkAllOf(Lottos lottos) {
        LottoResultPack resultPack = new LottoResultPack();

        for (Lotto lotto : lottos.values()) {
            resultPack.put(matchResultOf(lotto));
        }

        return resultPack;
    }

    protected LottoRank matchResultOf(Lotto lotto) {
        int matchCount = 0;
        for (int i = 0; i < LOTTO_NUMBER_COUNT; ++i) {
            final int index = i;
            matchCount += normalNumbers.stream()
                    .filter(n -> n == lotto.numbers(index))
                    .count();
        }
        boolean matchBonus = lotto.numbers().stream()
                .anyMatch(lottoNum -> bonusNumber.isMatch(lottoNum));

        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoWinBonusNumber(bonusNumber);
    }
}
