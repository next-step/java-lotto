package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.Winning;
import dev.dahye.lotto.util.DoubleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MUST_BE_REMAINDER = 0;
    private static final int WINNERS_COUNT = 6;
    private static final String WINNERS_DELIMITER = ",";
    private List<LottoTicket> lottoTickets;
    private LottoTicket winningTicket;
    private final int money;

    public LottoService(int money) {
        validateMoney(money);

        this.lottoTickets = new ArrayList<>();
        int lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(LottoTicket.autoIssued());
        }

        this.money = money;
    }

    public LottoService(int money, List<LottoTicket> lottoTickets) {
        this.money = money;
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private void validateMoney(int money) {
        if (isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean isNoRemainder(int money) {
        return money % LOTTO_PRICE != MUST_BE_REMAINDER;
    }

    protected int getTicketsCount() {
        return lottoTickets.size();
    }

    public List<Winning> getWinnings(String winningNumberInput) {
        List<Winning> winnings = new ArrayList<>();
        validateWinningNumbers(winningNumberInput);

        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningTicket);
            getWinning(winnings, matchCount);
        }

        return winnings;
    }

    private void validateWinningNumbers(String winningNumberInput) {
        validateWinnersNullOrEmpty(winningNumberInput);
        List<Integer> winningNumbers = convertStringToIntegerList(winningNumberInput);
        validateWinningNumberSize(winningNumbers);
        validateAlreadyAssignedWinningTicket();

        this.winningTicket = LottoTicket.manualIssued(winningNumbers);
    }

    private void validateAlreadyAssignedWinningTicket() {
        if (this.winningTicket != null) {
            throw new RuntimeException("이미 할당된 당첨 번호가 존재합니다.");
        }
    }

    private void getWinning(List<Winning> winnings, int matchCount) {
        if (Winning.isWinning(matchCount)) {
            winnings.add(Winning.getWinning(matchCount));
        }
    }

    private void validateWinnersNullOrEmpty(String winningNumberInput) {
        if (winningNumberInput == null || winningNumberInput.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 번호는 반드시 입력되어야 합니다.");
        }
    }

    private void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6개여야 합니다.");
        }
    }

    private List<Integer> convertStringToIntegerList(String input) {
        List<String> strings = Arrays.asList(input.split(WINNERS_DELIMITER));
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

    public double getWinningRate(List<Winning> winnings) {
        int totalPrize = 0;
        for (Winning winning : winnings) {
            totalPrize += winning.getPrize();
        }

        return DoubleUtils.parseDoubleSecondDigit(totalPrize / money);
    }
}
