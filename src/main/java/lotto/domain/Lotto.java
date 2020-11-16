package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> lottoPickNumber = new ArrayList<>();

    public Lotto createLottoNumber(LottoMachine lottoMachine) {
        lottoPickNumber = lottoMachine.createLottoNumber(lottoPickNumber);
        return this;
    }

    public boolean isCreatedLottoNumber() {
        return lottoPickNumber.size() == 6;
    }

    public List<Integer> getLottoPickNumber() {
        return lottoPickNumber;
    }

    public PrizeStatus matchPrizeNumber(List<Integer> prizeNumber) {
        long prizeCount = IntStream.range(0, prizeNumber.size())
                .filter(i -> lottoPickNumber.contains(prizeNumber.get(i)))
                .count();
        return new PrizeStatus(prizeCount);

    }
}
