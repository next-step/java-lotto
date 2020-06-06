package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final String WINNERS_DELIMITER = ",";
    private static final int WINNING_NUMBER_MAX_SIZE = 6;

    private final List<LottoTicket> lottoTickets;
    private final List<Integer> winningNumbers;

    public LottoResult(List<LottoTicket> lottoTickets, String winningNumberInput) {
        validateWinnersNullOrEmpty(winningNumberInput);
        List<Integer> winningNumbers = convertStringToIntegerList(winningNumberInput);

        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;

        validateWinningNumbers();
    }

    private void validateWinnersNullOrEmpty(String winningNumberInput) {
        if (winningNumberInput == null || winningNumberInput.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 번호는 반드시 입력되어야 합니다.");
        }
    }

    private List<Integer> convertStringToIntegerList(String input) {
        String[] strings = input.split(WINNERS_DELIMITER);
        List<Integer> ints = new ArrayList<>();

        for (String string : strings) {
            ints.add(convertStringToInteger(string.trim()));
        }

        return ints;
    }

    private int convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void validateWinningNumbers() {
        validateWinningNumberSize();
        LottoNumbers.validNumberRange(winningNumbers);
    }

    private void validateWinningNumberSize() {
        if (winningNumbers.size() != WINNING_NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6자리 숫자여야 합니다.");
        }
    }

    public List<Rank> getMyWinnings() {
        List<Rank> ranks = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            addWhenIsWinning(ranks, matchCount);
        }

        return ranks;
    }

    private void addWhenIsWinning(List<Rank> ranks, int matchCount) {
        if (Rank.canRanking(matchCount)) {
            ranks.add(Rank.valueOf(matchCount));
        }
    }

    public int getTotalCountWhenSpecificWinning(Rank target) {
        int count = 0;

        for (Rank rank : this.getMyWinnings()) {
            count = plusCountWhenEquals(count, rank, target);
        }

        return count;
    }

    private int plusCountWhenEquals(int count, Rank rank, Rank target) {
        if (rank.equals(target)) {
            count++;
        }
        return count;
    }

    public double getMyWinningRate(int money) {
        int totalPrize = 0;

        for (Rank rank : this.getMyWinnings()) {
            totalPrize += rank.getPrize();
        }

        return DoubleUtils.parseDoubleSecondDigit(totalPrize / money);
    }
}
