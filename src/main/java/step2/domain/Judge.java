package step2.domain;

import step2.dto.JudgeResponse;
import step2.dto.Price;
import step2.dto.ShopResponse;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private final int MATCH_CASE = 6 + 1;

    public JudgeResponse calculateResult(ShopResponse shopResponse, Lotto winningLotto) {
        HashSet<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());
        int[] matchCount = new int[MATCH_CASE];
        List<Integer> matches = shopResponse.getLottoList()
                .stream()
                .map(lotto -> calculateMatchCount(lotto, winningNumbers))
                .collect(Collectors.toList());
        matches.forEach(val -> matchCount[val]++);
        double profitIndex = calculateMoneyWon(matchCount) / shopResponse.getOriginMoney();
        return new JudgeResponse(matchCount[3], matchCount[4], matchCount[5], matchCount[6], profitIndex);
    }

    private double calculateMoneyWon(int[] matchCount) {
        return Price.threeMatchPrice * matchCount[3] +
                Price.fourMatchPrice * matchCount[4] +
                Price.fiveMatchPrice * matchCount[5] +
                Price.sixMatchPrice * matchCount[6];
    }

    private int calculateMatchCount(Lotto lotto, HashSet<Integer> winningNumbers) {
        return 0;
    }

}
