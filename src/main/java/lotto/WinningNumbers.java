package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WinningNumbers {
    int[] winNumbers;
    Map<Integer, Integer> map;

    public WinningNumbers(String[] winNumbers) {
        this(Stream.of(winNumbers).mapToInt(Integer::parseInt).toArray());
    }

    public WinningNumbers(int[] winNumbers) {
        map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> getWinNumbers(Lotto lotto) {
        return this.getWinNumbers(lotto.lotto());
    }

    public Map<Integer, Integer> getWinNumbers(List<LottoNumbers> lottoNumbers) {
        choose(lottoNumbers);
        return map;
    }

    private void choose(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            List<Integer> lottoNumberList = lottoNumber.lottoNumbers();
            count(lottoNumberList);
        }
    }

    private void count(List<Integer> lottoNumberList) {
        int correct = 0;
        for (int win : winNumbers) {
            if (lottoNumberList.contains(win)) {
                correct++;
            }
        }
        map.put(correct, map.getOrDefault(correct, 0) + 1);
    }
}
