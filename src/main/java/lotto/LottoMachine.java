package lotto;

import java.math.BigDecimal;

public class LottoMachine {

    private static final Money LOTTO_PRICE = new Money(1000);

    public LottoMachine() { }

    public Lottos buyLottos(long inputMoney, LottoNumberMachine lottoNumberMachine) {
        Money money = new Money(inputMoney);
        int numberOfLottos = money.countCanBuy(LOTTO_PRICE);

        return createLottos(numberOfLottos, lottoNumberMachine);
    }

    private Lottos createLottos(int numberOfLottos, LottoNumberMachine lottoNumberMachine) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.addNewLotto(lottoNumberMachine.lottoNumbers());
        }

        return lottos;
    }

    public LottoResult calculateMatchCount(Lottos lottos, WinnerLotto winLotto) {
        return new LottoResult(lottos.calculateMatchCount(winLotto));
    }

    public BigDecimal calculateProfit(LottoResult lottoResult) {
        return lottoResult.calculateProfit(LOTTO_PRICE);
    }
}
