package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchasedLottos {
    List<LottoNumbers> lottoNumbers;

    public PurchasedLottos(int purchaseCount) {

        this.lottoNumbers = IntStream.range(0,purchaseCount)
                .mapToObj(i -> LottoNumbers.randomNumbers())
                .collect(Collectors.toList());
    }

    public PurchasedLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> values() {
        return lottoNumbers;
    }

    public int count() {
        return lottoNumbers.size();
    }
}
