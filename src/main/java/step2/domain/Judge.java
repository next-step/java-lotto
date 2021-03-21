package step2.domain;

import step2.dto.JudgeResponseDTO;
import step2.dto.LottoDTO;
import step2.dto.LottoListDTO;
import step2.dto.ShopResponseDTO;
import step2.constants.Price;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private static final int MATCH_CASE = 7;

    public JudgeResponseDTO calculateResult(ShopResponseDTO shopResponse, LottoDTO winningLotto) {
        HashSet<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());
        int[] matchCount = new int[MATCH_CASE];
        LottoListDTO lottoList = shopResponse.getLottoList();
        List<Integer> matches = lottoList.getLottoList()
                .stream()
                .map(lotto -> calculateMatchCount(lotto, winningNumbers))
                .collect(Collectors.toList());
        for (Integer match : matches) {
            matchCount[match]++;
        }
        double profitIndex = calculateMoneyWon(matchCount) / shopResponse.getOriginMoney();
        return new JudgeResponseDTO(matchCount[3], matchCount[4], matchCount[5], matchCount[6], profitIndex);
    }

    private double calculateMoneyWon(int[] matchCount) {
        return Price.THREE_MATCH_PRICE * matchCount[3] +
                Price.FOUR_MATCH_PRICE * matchCount[4] +
                Price.FIVE_MATCH_PRICE * matchCount[5] +
                Price.SIX_MATCH_PRICE * matchCount[6];
    }

    private int calculateMatchCount(LottoDTO lotto, HashSet<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            count += oneIfNumberIsInHashSet(number, winningNumbers);
        }
        return count;
    }

    private int oneIfNumberIsInHashSet(int number, HashSet<Integer> numbers) {
        return numbers.contains(number)?1:0;
    }
}
