package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {

    private Integer lottoSequence;
    private List<Integer> lottoPickNumber = new ArrayList<>();
    private PrizeInformation prizeInformation;

    public Lotto (Integer lottoSequence,LottoMachine lottoMachine) {
        this.lottoSequence = lottoSequence;
        this.lottoPickNumber = lottoMachine.createLottoNumber(lottoPickNumber);
    }

    public void matchPrizeNumber(List<Integer> prizeNumber) {
        int prizeCount =(int) IntStream.range(0, prizeNumber.size())
                .filter(i -> lottoPickNumber.contains(prizeNumber.get(i)))
                .count();
       this.prizeInformation = PrizeInformation.findByPrizePrice(prizeCount);
    }
    public List<Integer> getLottoPickNumber() {
        return lottoPickNumber;
    }

    public PrizeInformation getPrizeInformation() {
        return prizeInformation;
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
