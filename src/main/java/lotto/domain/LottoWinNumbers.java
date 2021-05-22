package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import static lotto.domain.LottoGameOptions.*;

public class LottoWinNumbers {
    private LottoWinNormalNumbers normalNumbers;
    private LottoNumber bonusNumber;

    public LottoWinNumbers(String normalNumbers, int bonusNumber) {
        this.normalNumbers = new LottoWinNormalNumbers(normalNumbers);
        if (this.normalNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호의 일반 번호들과 보너스 번호는 중복이 불가합니다.");
        }
        this.bonusNumber = LottoNumber.of(bonusNumber);
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
                    .filter(lottoNumber -> lottoNumber == lotto.numbers().get(index))
                    .count();
        }
        boolean matchBonus = lotto.numbers()
                .stream()
                .anyMatch(lottoNumber -> bonusNumber == lottoNumber);

        return LottoRank.valueOf(matchCount, matchBonus);
    }

}
