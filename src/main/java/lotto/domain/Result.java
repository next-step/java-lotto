package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<LottoNumber> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Map<String, Integer> resultMap;

    public Result(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        resultMap = new HashMap<>();
    }

    public void matchList() {
        for (LottoNumber lottoNumber : lottoNumbers) {
            int count = lottoNumber.matches(winningNumbers);
            int preCount = resultMap.get(String.valueOf(count));
            resultMap.put(String.valueOf(count), preCount+1);
        }
    }

    public void statistics() {

    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }
}
