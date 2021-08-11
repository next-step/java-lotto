package step2.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public List<Integer> getNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.getNumbers();
    }

    public List<List<Integer>> getLotto(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        while (lottoCount-- > 0) {
            lottoList.add(getNumbers(new AutoLottoStrategy()));
        }

        return lottoList;
    }

    public Map<Integer, Integer> getWinningResult(List<List<Integer>> lottoList, List<Integer> winningNumberList) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(WinningRule.RULE_1.getNumberCount(), 0);
        result.put(WinningRule.RULE_2.getNumberCount(), 0);
        result.put(WinningRule.RULE_3.getNumberCount(), 0);
        result.put(WinningRule.RULE_4.getNumberCount(), 0);

        for (List<Integer> lotto : lottoList) {
            Set<Integer> duplicatedNumbers = getDuplicatedNum(combineAll(winningNumberList, lotto));

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
