package src.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private LottoGameNumberGenerator lottoGameNumberGenerator;

    public LottoMachine(LottoGameNumberGenerator lottoGameNumberGenerator) {
        this.lottoGameNumberGenerator = lottoGameNumberGenerator;
    }

    public Lottos buyLottos(Money money) {
        int lottoCount = money.lottoCount(Lotto.PRICE_OF_LOTTO);
        checkAvailableForPurchase(lottoCount);
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(idx -> buyLotto())
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

    private void checkAvailableForPurchase(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("로또의 가격은 " + Lotto.PRICE_OF_LOTTO + "원 입니다.");
        }
    }

    private Lotto buyLotto() {
        return Lotto.of(lottoGameNumberGenerator.gameNumbers());
    }

    public void changeLottoGameNumberGenerator(LottoGameNumberGenerator lottoGameNumberGenerator) {
        this.lottoGameNumberGenerator = lottoGameNumberGenerator;
    }
}
