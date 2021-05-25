package lotto.domain;


public class LottoMachine {
    private LottoMachine() {
    }

    public static Lottos buyWith(int amount) {
        int lottoSize = amount / Lotto.PRICE;
        Lottos lottos = new Lottos();
        for (int i = lottoSize; i > 0; i--) {
            lottos.add(LottoGenerator.getLotto());
        }
        return lottos;
    }
}
