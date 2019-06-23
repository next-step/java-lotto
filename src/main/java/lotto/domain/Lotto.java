package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.domain.validator.LottoNumberValidator;

import java.util.List;

public class Lotto {

    private static final RandomLottoGenerator RANDOM_LOTTO_GENERATOR = new RandomLottoGenerator();
    private final List<Integer> lottoNumbers;

    public Lotto() {

        this(RANDOM_LOTTO_GENERATOR);
    }

    public Lotto(LottoGenerator lottoGenerator) {

        List<Integer> lottoNumbers = lottoGenerator.generate();
        LottoNumberValidator.validate(lottoNumbers);
        sortLottoNumberAsc(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public boolean isMatchPrizeRule(PrizeRule prizeRule, WonNumbers wonNumbers) {

        return isMatchNormalNumberRule(prizeRule.getNormalNumberCount(), wonNumbers.getWonNormalNumbers()) &&
                isMatchBonusRule(prizeRule.hasBonusNumber(), wonNumbers.getWonBonusNumberValue());
    }

    private boolean isMatchNormalNumberRule(int normalNumberCount, List<Integer> wonNormalNumbers) {

        return wonNormalNumbers
                .stream()
                .filter(lottoNumbers::contains)
                .count() == normalNumberCount;
    }

    private boolean isMatchBonusRule(boolean hasBonusNumber, int wonBonusNumber) {

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
