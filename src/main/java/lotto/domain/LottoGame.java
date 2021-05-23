package lotto.domain;

public class LottoGame {

    public Lottos buyLottos(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; ++i) {
            lottos.buyAuto();
        }
        return lottos;
    }

}
