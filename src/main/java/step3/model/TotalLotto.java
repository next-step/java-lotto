package step3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import step3.constant.WinnerPrice;

public class TotalLotto {

    private static final int MAX_WINNING = 6;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private ArrayList<LottoNumbers> totalLotto;

    public TotalLotto() {
        totalLotto = new ArrayList<>();
    }

    public int size() {
        return totalLotto.size();
    }

    public void addLottoOne(LottoNumbers lottoNumbers) {
        totalLotto.add(lottoNumbers);
    }

    public ArrayList<LottoNumbers> totalLotto() {
        return totalLotto;
    }

    public List<List<Integer>> lotto() {
        List<List<Integer>> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : totalLotto) {
            result.add(lottoNumbers.numbers());
        }
        return result;
    }

    public List<Integer> getWinningWithNumbers(
            LottoNumbers victoryNumber) {

        List<Integer> result = initWithNumbers();
        for (LottoNumbers lotto : totalLotto) {
            int countWinning = lotto.countWinning(victoryNumber);
            result.set(countWinning, result.get(countWinning) + 1);
        }

        return result;
    }

    private List<Integer> initWithNumbers() {
        List<Integer> result = new ArrayList<Integer>();
        for (int index = 0; index < MAX_WINNING + 1; index++) {
            result.add(0);
        }
        return result;
    }

    public String getBenefit(LottoNumbers victoryNumber, Price price) {
        List<Integer> winning = getWinningWithNumbers(victoryNumber);

        BigDecimal result = calculator(WinnerPrice.TREE.price(), winning,
            THREE);
        result.add(calculator(WinnerPrice.FOUR.price(), winning, FOUR));
        result.add(calculator(WinnerPrice.FIVE.price(), winning, FIVE));
        result.add(calculator(WinnerPrice.SIX.price(), winning, SIX));

        return result
            .divide(new BigDecimal(price.value()), 2, RoundingMode.DOWN)
            .toString();
    }

    private BigDecimal calculator(int price, List<Integer> winning, int index) {
        return new BigDecimal(price)
            .multiply(new BigDecimal(winning.get(index)));
    }

}
