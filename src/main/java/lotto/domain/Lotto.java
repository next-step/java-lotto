package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.domain.validator.LottoValidator;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final RandomLottoGenerator RANDOM_LOTTO_GENERATOR = new RandomLottoGenerator();
    private final List<Integer> lottoNumbers;

    public Lotto() {

        this(RANDOM_LOTTO_GENERATOR);
    }

    public Lotto(LottoGenerator lottoGenerator) {

        List<Integer> generatedLottoNumbers = lottoGenerator.generate();
        LottoValidator.validateNumbers(generatedLottoNumbers);

        this.lottoNumbers = generatedLottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
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
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
