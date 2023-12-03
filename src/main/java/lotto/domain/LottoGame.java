package lotto.domain;


public class LottoGame {

    public Lottos startGame(int lottoCount) {
        Lottos lottos = new Lottos(lottoCount);
        return lottos;
    }
}
