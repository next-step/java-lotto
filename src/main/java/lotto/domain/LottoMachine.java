package lotto.domain;


public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoList buyWith(int amount) {
        int lottoSize = amount / Lotto.PRICE;
        LottoList lottos = new LottoList();
        for (int i = lottoSize; i > 0; i--) {
            lottos.add(LottoGenerator.getLotto());
        }
        return lottos;
    }
}
