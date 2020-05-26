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

    private int purchaseCount;
    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Integer, Integer> correctNumberMap = new HashMap<>();
    private ResultView resultView;

    public void create(int purchaseAmount, ResultView resultView) {
        this.resultView = resultView;
        this.purchaseAmount = purchaseAmount;

        printPurchaseAmount(purchaseAmount);
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.create(new Random());
            lottos.add(lotto);
        }
    }

    private void printPurchaseAmount(int purchaseAmount) {
        purchaseCount = purchaseAmount / LOTTO_PRICE;
        if (purchaseCount < ONE) {
            throw new IllegalArgumentException("로또 한 장의 값은 " + LOTTO_PRICE + "원입니다.");
        }

        System.out.println(purchaseCount + "개를 구매했습니다.");
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

    public Double calculateRateOfProfit() {
        return calculateProfit() / purchaseAmount;
    }

    private double calculateProfit() {
        return correctNumberMap.getOrDefault(3,0) * 5000 +
            correctNumberMap.getOrDefault(4,0) * 50000 +
            correctNumberMap.getOrDefault(5,0) * 1500000 +
            correctNumberMap.getOrDefault(6,0) * 2000000000;
    }

    public void printRateOfProfit(double rateOfProfit) {
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfProfit)  + "입니다.");
    }

    @Override
    public String toString() {
        return "LottoGame{" +
            "purchaseCount=" + purchaseCount +
            ", lottos=" + lottos +
            ", correctNumberMap=" + correctNumberMap +
            '}';
    }
}
