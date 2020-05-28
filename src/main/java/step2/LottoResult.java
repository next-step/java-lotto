package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Integer> winningNumberList;

    public LottoResult(String winningNumbers) {
        winningNumberList = new ArrayList();
        String[] split = winningNumbers.split(",");
        for (String number : split) {
            winningNumberList.add(Integer.parseInt(number.trim()));
        }
    }

    public int getCountLottoNumberWinning(List<Integer> lottoNumberList) {
        int count = 0;

        for (Integer number : lottoNumberList) {
            count += isWinningNumber(number);
        }

        return count;
    }

    private int isWinningNumber(int number) {
        return winningNumberList.contains(number) ? 1 : 0;
    }
}
