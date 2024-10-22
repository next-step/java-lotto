package lotto.entity;


import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_UNIT_PRICE = 1000;

    private LottoMachine() {

    }

    public static List<Lotto> insert(int inputMoney) {
        final LottoRandomizer lottoRandomizer = new LottoRandomizer();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getLottoCount(inputMoney); i++) {
            lottos.add(issue(lottoRandomizer.lottoShuffle()));
        }
        return lottos;
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }

    private static Lotto issue(List<Integer> numberRandomizer) {
        return new Lotto(numberRandomizer);
    }
}
