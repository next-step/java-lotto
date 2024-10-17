package lotto.entity;


import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_UNIT_PRICE = 1000;

    private LottoMachine() {

    }

    public static List<Lotto> insert(int inputMoney) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < getLottoCount(inputMoney); i++) {
            List<Integer> numberRandomizer = LottoRandomizer.create();
            lottos.add(issue(numberRandomizer));
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
