package lotto.model;

import java.util.*;

public class WinningNumber {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private static final int WINNING_NUMBER_QUANTITY = 6;
    private final Map<Rank, Integer> lottoMatch = new EnumMap<>(Rank.class);

    public WinningNumber(LottoCollection lottoCollection, List<String> winningNumbers) {
        validation(winningNumbers);
        List<Integer> winnerCollection = lottoCollection.findWinner(winningNumbers);

        for (int i = 0; i < winnerCollection.size(); i++) {
            lottoMatch.put(Rank.values()[i], winnerCollection.get(i));
        }
    }

    public List<Integer> countWinning() {
        List<Integer> matchingCount = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            matchingCount.add(getMatchingCount(rank::event));
        }

        return matchingCount;
    }

    public int getMatchingCount(MatchNumber matchNumber) {
        return (int) lottoMatch.values().stream()
                .filter(matchNumber::isMatch)
                .count();
    }

    private void validation(List<String> winningNumbers) {
        checkLength(winningNumbers);
        checkBounds(winningNumbers);
    }

    private void checkBounds(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (isOutOfNumberBounds(winningNumber)) {
                throw new IllegalArgumentException("당첨번호를 확인해주세요");
            }
        }
    }

    private void checkLength(List<String> winningNumbers) {
        if (isLessThanNumberQuantity(winningNumbers)) {
            throw new IllegalArgumentException("당첨번호 개수를 확인해주세요");
        }
    }

    private boolean isLessThanNumberQuantity(List<String> winningNumbers) {
        return winningNumbers.size() != WINNING_NUMBER_QUANTITY;
    }

    private boolean isOutOfNumberBounds(String winningNumber) {
        return Integer.parseInt(winningNumber) > LOTTO_END_NUMBER || Integer.parseInt(winningNumber) < LOTTO_START_NUMBER;
    }
}
