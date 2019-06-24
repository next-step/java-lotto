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

        List<Integer> generatedLottoNumbers = lottoGenerator.generate();
        LottoNumberValidator.validate(generatedLottoNumbers);

        this.lottoNumbers = generatedLottoNumbers;
    }

    public boolean isMatchPrizeRule(PrizeRule prizeRule, WonNumbers wonNumbers) {

        return isMatchNormalNumberRule(prizeRule.getNormalNumberCount(), wonNumbers.getNormalNumbers()) &&
                isMatchBonusRule(prizeRule.hasBonusNumber(), wonNumbers.getBonusNumbers());
    }

    private boolean isMatchNormalNumberRule(int normalNumberCount, List<WonNumber> normalWonNumbers) {

        return normalWonNumbers.stream()
                .map(WonNumber::getNumber)
                .filter(lottoNumbers::contains)
                .count() == normalNumberCount;
    }

    private boolean isMatchBonusRule(boolean hasBonusNumber, List<WonNumber> bonusWonNumbers) {

        return hasBonusNumber == bonusWonNumbers.stream()
                .map(WonNumber::getNumber)
                .anyMatch(lottoNumbers::contains);
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
