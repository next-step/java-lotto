package study.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchasedLottos {
    List<Lotto> lottoNumbers;

    public PurchasedLottos(int purchaseCount) {

        this.lottoNumbers = IntStream.range(0,purchaseCount)
                .mapToObj(i -> Lotto.randomNumbers())
                .collect(Collectors.toList());
    }

    public PurchasedLottos(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> values() {
        return lottoNumbers;
    }

    public int count() {
        return lottoNumbers.size();
    }
}
