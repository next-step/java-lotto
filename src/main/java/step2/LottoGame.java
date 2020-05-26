package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private int PURCHASE_COUNT;
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Integer, Integer> correctMap = new HashMap<>();

    public void create(int purchaseAmount) {
        printPurchaseAmount(purchaseAmount);

        for (int i = 0; i < PURCHASE_COUNT; i++) {
            Lotto lotto = Lotto.create(new Random());
            lottos.add(lotto);
        }
    }

    private void printPurchaseAmount(int purchaseAmount) {
        PURCHASE_COUNT = purchaseAmount / LOTTO_PRICE;
        if (PURCHASE_COUNT < 1) {
            throw new IllegalArgumentException("로또 한 장의 값은 " + LOTTO_PRICE + "원입니다.");
        }

        System.out.println(PURCHASE_COUNT + "개를 구매했습니다.");
    }

    public void printLottos(ResultView resultView) {
        resultView.print(lottos);
    }

    public void print(int [] lastLottoNumbers) {
        for (Lotto lotto : lottos) {
            long count = Arrays.stream(lastLottoNumbers)
                .filter(lotto::containNumber)
                .count();

            System.out.println("count = " + count);
        }
    }
}
