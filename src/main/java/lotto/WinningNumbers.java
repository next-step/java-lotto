package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbers {
    int[] winNumbers;
    Map<Integer, Integer> map;

    public WinningNumbers(int[] winNumbers) {
        map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> getWinNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            List<Integer> lottoNumberList = lottoNumber.lottoNumbers();
            countWinNumbers(lottoNumberList);
        }
        return map;
    }

    private void countWinNumbers(List<Integer> lottoNumberList) {
        int correct = 0;
        for (int win : winNumbers) {
            if (lottoNumberList.contains(win)) {
                correct++;
            }
        }
        map.put(correct, map.getOrDefault(correct, 0) + 1);
    }
}
