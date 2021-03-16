package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Win {
    int[] winNumbers;

    public Win(int[] winNumbers) {
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> getWinNumbers(List<LottoNumbers> lottoNumbers) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);

        for (LottoNumbers lottoNumber : lottoNumbers) {
            List<Integer> lottoNumberList = lottoNumber.getLottoNumbers();
            int correct = 0;
            for (int win : winNumbers) {
                if (lottoNumberList.contains(win)) {
                    correct++;
                }
            }
            map.put(correct, map.getOrDefault(correct, 0) + 1);
        }
        return map;
    }
}
