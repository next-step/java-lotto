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

        if (prizeRule.hasBonusNumber()) {
            return isMatchNormalNumberCount(prizeRule.getNormalNumberCount(), wonNumbers.getWonNormalNumbers()) &&
                    isMatchBonusNumber(wonNumbers.getWonBonusNumberValue());
        }

        return isMatchNormalNumberCount(prizeRule.getNormalNumberCount(), wonNumbers.getWonNormalNumbers());
    }

    private boolean isMatchNormalNumberCount(int normalNumberCount, List<Integer> wonNormalNumbers) {

        return wonNormalNumbers
                .stream()
                .filter(lottoNumbers::contains)
                .count() == normalNumberCount;
    }

    private boolean isMatchBonusNumber(int wonBonusNumber) {

        return lottoNumbers.contains(wonBonusNumber);
    }

    private void sortLottoNumberAsc(List<Integer> lottoNumbers) {

        lottoNumbers.sort(Integer::compareTo);
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
