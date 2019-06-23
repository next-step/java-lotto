package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.domain.validator.LottoNumberValidator;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto() {

        this(new RandomLottoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {

        List<Integer> lottoNumbers = lottoGenerator.generate();
        LottoNumberValidator.validate(lottoNumbers);
        sortLottoNumberAsc(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public boolean isMatchPrizeRule(PrizeRule prizeRule, WonNumbers wonNumbers) {

        return isMatchNormalNumberCount(prizeRule.getNormalNumberCount(), wonNumbers.getWonNormalNumbers()) &&
                isMatchBonusNumber(prizeRule.hasBonusNumber(), wonNumbers.getWonBonusNumberValue());
    }

    private boolean isMatchNormalNumberCount(int normalNumberCount, List<Integer> wonNormalNumbers) {

        return wonNormalNumbers
                .stream()
                .filter(lottoNumbers::contains)
                .count() == normalNumberCount;
    }

    private boolean isMatchBonusNumber(boolean hasBonusNumber, int wonBonusNumber) {

        return hasBonusNumber == lottoNumbers.contains(wonBonusNumber);
    }

    private void sortLottoNumberAsc(List<Integer> lottoNumbers) {

        lottoNumbers.sort(Integer::compareTo);
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
