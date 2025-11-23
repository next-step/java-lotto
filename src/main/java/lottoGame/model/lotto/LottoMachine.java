package lottoGame.model.lotto;

import static java.util.stream.IntStream.range;
import static lottoGame.model.lotto.LottoNumFactory.createLotto;

import java.util.List;
import lottoGame.model.price.BuyPrice;

public class LottoMachine {

    public static final int LOTTO_NUM_COUNT = 6;

    private final int perLottoPrice;

    public LottoMachine(int perLottoPrice) {
        this.perLottoPrice = perLottoPrice;
    }

    public Lottos publish(BuyPrice buyPrice) {
        List<Lotto> lottos = range(0, buyPrice.calculateLottoCount(perLottoPrice))
                .mapToObj(idx ->
                        new Lotto(
                                createLotto(LOTTO_NUM_COUNT)
                        )
                ).toList();

        return new Lottos(lottos);
    }
}
