package step2.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        this.result = new HashMap<>();
        for (Rank rule : Rank.values()) {
            result.put(rule, 0);
        }
    }

    private List<Integer> combineAll(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.addAll(winningNumbers);
        allNumbers.addAll(lottoNumbers);

        return allNumbers;
    }

    private Set<Integer> getDuplicatedNum(List<Integer> allNumbers) {
        return allNumbers.stream()
                .filter(i -> Collections.frequency(allNumbers, i) > 1)
                .collect(Collectors.toSet());
    }

    private boolean isMatchBonus(List<Integer> matchNumbers, int bonus) {
        return matchNumbers.contains(bonus);
    }

    public Map<Rank, Integer> getResult(LottoGroup lottoGroup, Winning winning) {
        for (Lotto lotto : lottoGroup.getLottoList()) {
            List<Integer> allNumbers = combineAll(winning.getWinningNumber(), lotto.getLottoNumbers());
            Set<Integer> matchNumbers = getDuplicatedNum(allNumbers);
            boolean matchBonus = isMatchBonus(lotto.getLottoNumbers(), winning.getBonus());

            saveWinningResult(result, matchNumbers, matchBonus);
        }

        return result;
    }

    private void saveWinningResult(Map<Rank, Integer> result, Set<Integer> matchNumbers, boolean matchBonus) {
        int countOfMatch = matchNumbers.size();
        Rank rank = Rank.getRank(countOfMatch, matchBonus);
        result.put(rank, result.get(rank)+1);
    }


    public String getWinningRate(PurchaseAmount purchaseAmount, Map<Rank, Integer> winningResult) {
        int totalWinPrice = 0;

        for (Rank rule : Rank.values()) {
            int winningCount = winningResult.get(rule);
            totalWinPrice += rule.getWinningPrice() * winningCount;
        }

        double result = (double) totalWinPrice / (double) purchaseAmount.getPurchaseAmount();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(result);
    }
}
