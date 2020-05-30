package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MUST_BE_REMAINDER = 0;
    private static final int WINNERS_COUNT = 6;
    private static final String WINNERS_DELIMITER = ",";
    private final List<LottoTicket> lottoTickets;

    public LottoService(int money) {
        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;
        this.lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(LottoTicket.issued());
        }
    }

    private void validateMoney(int money) {
        if (isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean isNoRemainder(int money) {
        return money % LOTTO_PRICE != MUST_BE_REMAINDER;
    }

    public int getTotalCount() {
        return lottoTickets.size();
    }

    public void getWinners(String winnerNumbers) {
        List<Integer> winners = validateWinnerNumbers(winnerNumbers);
    }

    private List<Integer> validateWinnerNumbers(String winnerNumbers) {
        validateWinnersNullOrEmpty(winnerNumbers);
        List<Integer> winners = convertStringListToIntegerList(Arrays.asList(winnerNumbers.split(WINNERS_DELIMITER)));
        validateWinnerSize(winners);

        return winners;
    }

    private void validateWinnersNullOrEmpty(String winnerNumbers) {
        if (winnerNumbers == null || winnerNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 번호는 반드시 입력되어야 합니다.");
        }
    }

    private void validateWinnerSize(List<Integer> winners) {
        if (winners.size() != WINNERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6개여야 합니다.");
        }
    }

    private List<Integer> convertStringListToIntegerList(List<String> strings) {
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
}
