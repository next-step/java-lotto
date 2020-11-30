package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoNumber {

    private Set<Integer> lottoNumbers;

    private LottoNumber(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumber from(Set<Integer> lottoNumbers) {
        ProviderLottoNumbers.isValidLottoNumber(lottoNumbers);
        return new LottoNumber(lottoNumbers);
    }

    public Set<Integer> getLottoNumber() {
        return lottoNumbers;
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoNumbers.stream()
                .filter(prizeLotto::existByLottoNumber)
                .count();
        boolean isBonusball = matchBonusball(prizeLotto);
        return PrizeInformation.findByPrizePrice(MatchStatus.of(prizeCount, isBonusball));
    }

    private boolean matchBonusball(PrizeLotto prizeLotto) {
        return lottoNumbers
                .stream()
                .anyMatch(prizeLotto::matchBonusBall);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public static Bonusball createBonusball(int bonusBallNumber) {
        return new Bonusball(bonusBallNumber);
    }

    public static class Bonusball  {

        private int bonusBall;

        private Bonusball(int bonusBall) {
            ProviderLottoNumbers.isValidRange(bonusBall);
            this.bonusBall = bonusBall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bonusball bonusball = (Bonusball) o;
            return bonusBall == bonusball.bonusBall;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bonusBall);
        }
    }

}
