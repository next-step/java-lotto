package step3.model;

import java.util.ArrayList;
import java.util.List;

public class TotalLotto {

    private static final int MAX_WINNING = 6;
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
            ArrayList<Integer> winningNumber) {

        List<Integer> result = initWithNumbers();
        for (LottoNumbers lotto : totalLotto) {
            int countWinning = lotto.countWinning(winningNumber);
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

}
