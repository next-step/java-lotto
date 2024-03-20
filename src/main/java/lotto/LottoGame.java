package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    List<Lotto> lottos;

    public LottoGame(int lottoPrice, int purchaseBudget) {
        int numberOfPurchase = purchaseBudget / lottoPrice;
        this.lottos = Stream.generate(Lotto::new).limit(numberOfPurchase).collect(Collectors.toList());
    }

    public int hasLottoCount() {
        return lottos.size();
    }
}
