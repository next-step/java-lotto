package lotto.domain;

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

    public static Ticket fromLottoNoList(List<LottoNo> numbers) {
        return new Ticket(numbers);
    }

    public PrizeType checkLotteryWinningStatus(WinningNumber winningNumber) {
        return PrizeType.create(countMatchingNumber(winningNumber), isBonusBallMatched(winningNumber));
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
}
