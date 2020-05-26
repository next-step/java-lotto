package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int DEFAULT_VALUE = 0;
    private static final int ONE = 1;

    private int PURCHASE_COUNT;
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Integer, Integer> correctNumberMap = new HashMap<>();
    private ResultView resultView;

    public void create(int purchaseAmount, ResultView resultView) {
        this.resultView = resultView;

        printPurchaseAmount(purchaseAmount);
        for (int i = 0; i < PURCHASE_COUNT; i++) {
            Lotto lotto = Lotto.create(new Random());
            lottos.add(lotto);
        }
    }

    private void printPurchaseAmount(int purchaseAmount) {
        PURCHASE_COUNT = purchaseAmount / LOTTO_PRICE;
        if (PURCHASE_COUNT < ONE) {
            throw new IllegalArgumentException("로또 한 장의 값은 " + LOTTO_PRICE + "원입니다.");
        }

        System.out.println(PURCHASE_COUNT + "개를 구매했습니다.");
    }

    public void printLottos() {
        resultView.print(lottos);
    }

    public void countCorrectNumbers(int [] lastLottoNumbers) {
        for (Lotto lotto : lottos) {
            int count = Arrays.stream(lastLottoNumbers)
                .filter(lotto::containNumber)
                .map(i -> ONE)
                .sum();

            putCorrectNumberMap(count);
        }
    }

    private void putCorrectNumberMap(int count) {
        correctNumberMap.put(count, correctNumberMap.getOrDefault(count, DEFAULT_VALUE) + ONE);
    }

    public void printStatistics() {
        resultView.printCollectMap(correctNumberMap);
    }

    @Override
    public String toString() {
        return "LottoGame{" +
            "PURCHASE_COUNT=" + PURCHASE_COUNT +
            ", lottos=" + lottos +
            ", correctNumberMap=" + correctNumberMap +
            '}';
    }


}
