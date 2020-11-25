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
        return PrizeInformation.findByPrizePrice(prizeCount);
    }

    public Set<Integer> getLottoPickNumber() {
        return lottoPickNumber;
    }

}