package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 45;
    private static final int LOTTO_LIMITED_COUNT = 6;
    private static final int WIN_3 = 3;
    private static final int WIN_4 = 4;
    private static final int WIN_5 = 5;
    private static final int WIN_6 = 6;
    private static final int[] winPrice = {5000, 50000, 1500000, 2000000000};
    private static int[] winResult = {0, 0, 0, 0};   // 3개, 4개, 5개, 6개 일치
    private static List<List<Integer>> lottos;

    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView result = new ResultView();

        int lottoCost = input.inputCost();
        int lottoCount = calcLottoCount(lottoCost);

        result.showLottoCount(lottoCount);
        result.showLottos(makeLottoList(lottoNumbersSetting(), lottoCount));
        result.moveLine();
        winNCheckNumber(lottos, input.inputPickNumbers());
        result.moveLine();

        result.showStastics(winResult, winPrice, profitRate(totalPrice(winResult, winPrice), lottoCost));
    }

    protected static double profitRate(int totalPrice, int lottoCost) {
        return Double.parseDouble(String.format("%.2f", (totalPrice / (double)lottoCost)));
    }

    protected static int totalPrice(int[] winResult, int[] winPrice) {
        int total = 0;
        for(int i = 0; i < winResult.length; i++) {
            total += (winResult[i] * winPrice[i]);
        }

        return total;
    }
    private static void winNCheckNumber(List<List<Integer>> lottos, List<Integer> inputPickNumbers) {
        for(List<Integer> lotto : lottos) {
            containsCheckLotto(inputPickNumbers, lotto);
        }
    }

    private static void containsCheckLotto(List<Integer> inputPickNumbers, List<Integer> lotto) {
        int cntSum = 0;
        for(int pickNumber : inputPickNumbers) {
            cntSum += containsPerOneLotto(lotto, pickNumber);
            doWinResult(cntSum);
        }
    }

    protected static int containsPerOneLotto(List<Integer> lotto, int pickNumber) {
        int cnt = 0;
        if(lotto.contains(pickNumber)) {
            cnt++;
        }
        return cnt;
    }

    private static void doWinResult(int cnt) {
        if(cnt == WIN_3) {
            winResult[0]++;
        }
        if(cnt == WIN_4) {
            winResult[1]++;
        }
        if(cnt == WIN_5) {
            winResult[2]++;
        }
        if(cnt== WIN_6) {
            winResult[3]++;
        }
    }

    protected static List<Integer> lottoNumbersSetting() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUMBER_TOTAL_COUNT; i++){
            numbers.add(i + 1);
        }

        return numbers;
    }

    protected static List<List<Integer>> makeLottoList(List<Integer> numbers, int lottoCount) {
        lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++) {
            lottos.add(new ArrayList<>());
            shuffleNumbers(numbers);

            for(int j = 0; j < LOTTO_LIMITED_COUNT; j++){
                lottos.get(i).add(numbers.get(j));
            }
            sortLottoNumbers(lottos.get(i));
        }

        return lottos;
    }

    protected static void sortLottoNumbers(List<Integer> oneLotto) {
        Collections.sort(oneLotto);
    }

    protected static void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    protected static int calcLottoCount(int cost) {
        return cost / PRICE_PER_LOTTO;
    }

}
