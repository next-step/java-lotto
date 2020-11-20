package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private Integer lottoSequence;
    private List<Integer> lottoPickNumber;

    public Lotto (Integer lottoSequence, LottoMachine lottoMachine) {
        this.lottoSequence = lottoSequence;
        this.lottoPickNumber = lottoMachine.createLottoNumber();
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoPickNumber.stream()
                .filter(lottoNumber -> prizeLotto.findByIndexNumber(lottoNumber))
                .count();
       return PrizeInformation.findByPrizePrice(prizeCount);
    }

    public List<Integer> getLottoPickNumber() {
        return lottoPickNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoSequence, lotto.lottoSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoSequence);
    }
}