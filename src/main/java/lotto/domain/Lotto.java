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

        this(lottoGenerator.generate());
    }

    public Lotto(List<Integer> lottoNumbers) {

        LottoValidator.validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isMatchPrizeRule(PrizeRule prizeRule, WonNumbers wonNumbers) {

        if (prizeRule.hasBonusNumber()) {
            return isMatchNormalNumberRule(prizeRule.getNormalNumberCount(), wonNumbers.getNormalNumbers()) &&
                    isMatchBonusRule(prizeRule.hasBonusNumber(), wonNumbers.getBonusNumber());
        }
        return isMatchNormalNumberRule(prizeRule.getNormalNumberCount(), wonNumbers.getNormalNumbers());
    }

    private boolean isMatchNormalNumberRule(int normalNumberCount, List<WonNumber> normalWonNumbers) {

        return normalWonNumbers.stream()
                .map(WonNumber::getNumber)
                .filter(lottoNumbers::contains)
                .count() == normalNumberCount;
    }

    private boolean isMatchBonusRule(boolean hasBonusNumber, WonNumber bonusWonNumbers) {

        return hasBonusNumber == lottoNumbers.contains(bonusWonNumbers.getNumber());
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
