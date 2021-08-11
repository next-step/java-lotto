package step2.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WinningResult {
    private Map<Integer, Integer> result;

    public WinningResult() {
        this.result = new HashMap<>();
        for (WinningRule rule : WinningRule.values()) {
            result.put(rule.getNumberCount(), 0);
        }
    }

    private List<Integer> combineAll(List<Integer> winningNumberList, List<Integer> lotto) {
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.addAll(lotto);
        allNumbers.addAll(winningNumberList);

        return allNumbers;
    }

    private Set<Integer> getDuplicatedNum(List<Integer> allNumbers) {
        Set<Integer> duplicatedNumbers = allNumbers.stream()
                .filter(i -> Collections.frequency(allNumbers, i) > 1)
                .collect(Collectors.toSet());

        return duplicatedNumbers;
    }

    public Map<Integer, Integer> getWinningResult(List<List<Integer>> lottoList, List<Integer> winningNumberList) {
        for (List<Integer> lotto : lottoList) {
            List<Integer> allNumbers = combineAll(winningNumberList, lotto);
            Set<Integer> duplicatedNumbers = getDuplicatedNum(allNumbers);

            saveWinningResult(result, duplicatedNumbers);
        }

        return result;
    }

    private void saveWinningResult(Map<Integer, Integer> result, Set<Integer> duplicatedNumbers) {
        int winNumberCount = duplicatedNumbers.size();
        if (result.containsKey(winNumberCount)) {
            result.put(winNumberCount, result.get(winNumberCount)+1);
        }
    }


    public String getWinningRate(int amount, Map<Integer, Integer> winningResult) {
        int totalWinPrice = 0;

        for (WinningRule rule : WinningRule.values()) {
            int winningCnt = winningResult.get(rule.getNumberCount());
            totalWinPrice += rule.getWinningPrice() * winningCnt;
        }

        double result = (double) totalWinPrice / (double) amount;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
}
