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
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private int purchaseCount;
    private int purchasePrice;
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Integer, Integer> matchedNumberMap = new HashMap<>();

    private LottoGame() {}

    public static LottoGame create(int purchasePrice) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.purchasePrice = purchasePrice;

        lottoGame.printPurchaseAmount(purchasePrice);
        for (int i = 0; i < lottoGame.purchaseCount; i++) {
            Lotto lotto = Lotto.create(new Random());
            lottoGame.lottos.add(lotto);
        }

        return lottoGame;
    }

    private void printPurchaseAmount(int purchaseAmount) {
        purchaseCount = purchaseAmount / LOTTO_PRICE;
        if (purchaseCount < ONE) {
            throw new IllegalArgumentException("로또 한 장의 값은 " + LOTTO_PRICE + "원입니다.");
        }

        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void countMatchedNumbers(String lastWinningNumber) {
        int[] lastLottoNumbers = convertToArray(lastWinningNumber);

        lottos.forEach(lotto -> {
            int count = getCount(lastLottoNumbers, lotto);
            putMatchedNumberMap(count);
        });
    }

    private int[] convertToArray(String lastWinningNumber) {
        return Arrays.stream(lastWinningNumber.trim().split(LOTTO_NUMBER_DELIMITER))
            .mapToInt(Integer::parseInt)
            .toArray();
    }


    private int getCount(int[] lastLottoNumbers, Lotto lotto) {
        return Arrays.stream(lastLottoNumbers)
                    .filter(lotto::containNumber)
                    .map(i -> ONE)
                    .sum();
    }

    private void putMatchedNumberMap(int count) {
        matchedNumberMap.put(count, matchedNumberMap.getOrDefault(count, DEFAULT_VALUE) + ONE);
    }

    public Double calculateRateOfProfit() {
        return calculateProfit() / purchasePrice;
    }

    private double calculateProfit() {
        return matchedNumberMap.getOrDefault(3,0) * 5000 +
            matchedNumberMap.getOrDefault(4,0) * 50000 +
            matchedNumberMap.getOrDefault(5,0) * 1500000 +
            matchedNumberMap.getOrDefault(6,0) * 2000000000;
    }

    public void printRateOfProfit(double rateOfProfit) {
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfProfit)  + "입니다.");
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public HashMap<Integer, Integer> getMatchedNumberMap() {
        return matchedNumberMap;
    }

    @Override
    public String toString() {
        return "LottoGame{" +
            "purchaseCount=" + purchaseCount +
            ", lottos=" + lottos +
            ", matchedNumberMap=" + matchedNumberMap +
            '}';
    }
}
