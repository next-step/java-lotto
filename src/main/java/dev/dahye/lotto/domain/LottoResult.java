package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final String WINNERS_DELIMITER = ",";

    private final LottoTickets lottoTickets;
    private final LottoTicket winningTicket;
    private final BonusBall bonusNumber;

    public LottoResult(LottoTickets lottoTickets, String winningNumberInput, int bonusNumber) {
        validateWinnersNullOrEmpty(winningNumberInput);
        List<Integer> winningNumbers = convertStringToIntegerList(winningNumberInput);

        this.lottoTickets = lottoTickets;
        this.winningTicket = LottoTicket.manualIssued(winningNumbers);
        this.bonusNumber = BonusBall.createBy(bonusNumber, this.winningTicket);
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

    public List<Rank> getMyRanks() {
        return this.lottoTickets.calculateWinningRate(winningTicket, bonusNumber);
    }

    public int getTotalCountOf(Rank target) {
        int count = 0;

        for (Rank rank : this.getMyRanks()) {
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

        for (Rank rank : this.getMyRanks()) {
            totalPrize += rank.getPrize();
        }

        return divideTotalPrizeByMoney(totalPrize, money);
    }

    public static double divideTotalPrizeByMoney(int totalPrize, int money) {
        return DoubleUtils.parseDoubleSecondDigit((double) totalPrize / money);
    }
}
