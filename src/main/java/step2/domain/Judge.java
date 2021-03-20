package step2.domain;

import step2.dto.JudgeResponse;
import step2.dto.ShopResponse;
import step2.utils.Price;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private static final int MATCH_CASE = 7;

    public JudgeResponse calculateResult(ShopResponse shopResponse, Lotto winningLotto) {
        HashSet<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());
        int[] matchCount = new int[MATCH_CASE];
        List<Integer> matches = shopResponse.getLottos()
                .getLottoList()
                .stream()
                .map(lotto -> calculateMatchCount(lotto, winningNumbers))
                .collect(Collectors.toList());
        for (Integer match : matches) {
            matchCount[match]++;
        }
        double profitIndex = calculateMoneyWon(matchCount) / shopResponse.getOriginMoney();
        return new JudgeResponse(matchCount[3], matchCount[4], matchCount[5], matchCount[6], profitIndex);
    }

    private double calculateMoneyWon(int[] matchCount) {
        return Price.THREE_MATCH_PRICE * matchCount[3] +
                Price.FOUR_MATCH_PRICE * matchCount[4] +
                Price.FIVE_MATCH_PRICE * matchCount[5] +
                Price.SIX_MATCH_PRICE * matchCount[6];
    }

    private int calculateMatchCount(Lotto lotto, HashSet<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            count += oneIfNumberIsInHashSet(number, winningNumbers);
        }
        return count;
    }

    private int oneIfNumberIsInHashSet(int number, HashSet<Integer> numbers) {
        if (numbers.contains(number)) return 1;
        return 0;
    }
}
