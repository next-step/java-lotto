package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private final List<LottoNo> numbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int SIZE_LOTTO_NUMBER = 6;
    public static final int LOTTO_PRICE = 1000;

    private Ticket(List<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers.stream()
                .map(LottoNo::from)
                .collect(Collectors.toList()));
    }

    public static Ticket fromString(String input) {
        return fromLottoNoList(splitAndMakeList(input));
    }

    public static Ticket fromLottoNoList(List<LottoNo> numbers) {
        return new Ticket(numbers);
    }

    public Prize checkLotteryWinningStatus(WinningNumber winningNumber) {
        return Prize.create(countMatchingNumber(winningNumber), isBonusBallMatched(winningNumber));
    }

    public int countMatchingNumber(WinningNumber winningNumber) {
        return winningNumber.countMatchingNumber(Ticket.fromLottoNoList(numbers));
    }

    public boolean isBonusBallMatched(WinningNumber winningNumber) {
        return winningNumber.isBonusBallMatched(Ticket.fromLottoNoList(numbers));
    }

    public List<LottoNo> getNumbers() {
        return numbers;
    }

    public boolean contains(LottoNo target) {
        return numbers.stream()
                .anyMatch(lottoNo -> lottoNo.equals(target));
    }

    private static List<LottoNo> splitAndMakeList(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(num -> {
                    try {
                        return LottoNo.from(num);
                    } catch (TicketNumberOutOfBoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
