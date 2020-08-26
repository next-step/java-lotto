package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameResult {
    private final static Integer ADD_COUNT = 1;
    private List<Integer> winningNumbers;
    private Map<Integer, Integer> matchCountResult = new HashMap<Integer, Integer>() {};

    public LottoGameResult(String winningLottoNumbers) {
        winningNumbers = Arrays.stream(winningLottoNumbers
                .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Integer, Integer> getMatchCountResult() {
        return matchCountResult;
    }

    public void setAutoIncrementMatchCountResult(Integer matchCount) {
        matchCountResult.put(matchCount, matchCountResult.getOrDefault(matchCount, 0) + ADD_COUNT);
    }

    Integer getMatchCount(List<Integer> lottoNumber) {
        return (int) lottoNumber.stream()
                                .filter(winningNumbers::contains)
                                .count();
    }

    public void makeMatchCountResult(List<Integer> lottoNumber) {
        setAutoIncrementMatchCountResult(getMatchCount(lottoNumber));
    }
}
