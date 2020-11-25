package lotto.domain;

import java.util.Set;

public class Lotto {

    private final Set<Integer> lottoPickNumber;

    public Lotto(Set<Integer> lottoPickNumbers) {
        this.lottoPickNumber = lottoPickNumbers;
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoPickNumber.stream()
                .filter(prizeLotto::existByIndexNumber)
                .count();
        boolean isBonusball = matchBonusball(prizeLotto);
        return PrizeInformation.findByPrizePrice(new MatchStatus(prizeCount, isBonusball));
    }

    private boolean matchBonusball(PrizeLotto prizeLotto) {
        return lottoPickNumber.stream().anyMatch(prizeLotto::matchBonusBall);
    }

    public Set<Integer> getLottoPickNumber() {
        return lottoPickNumber;
    }

}