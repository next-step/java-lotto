package lotto.domain;

import java.util.List;

public class LottoTicket {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    private LottoTicket(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        validateSize(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private LottoTicket(List<LottoNumber> numbers) {
        this(numbers, null);
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("입력 숫자에 중복이 존재합니다.");
        }
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("숫자의 입력값은 6개 여야 합니다.");
        }
    }

    public static LottoTicket createLottoTicketByAuto() {
        return new LottoTicket(LottoNumber.getRandomNumbers(NUMBER_OF_LOTTO_NUMBERS));
    }

    public static LottoTicket createLottoTicketByManual(List<Integer> numbers) {
        return new LottoTicket(LottoNumber.of(numbers));
    }

    public static LottoTicket createWinningTicket(List<Integer> numbers, Integer bonusNumber) {
        return new LottoTicket(LottoNumber.of(numbers), LottoNumber.of(bonusNumber));
    }

    public int getMatchCount(LottoTicket inputTicket) {
        return (int) numbers.stream().filter(inputTicket.numbers::contains).count();
    }

    public boolean isBonusMatched(LottoTicket winningTicket) {
        return numbers.stream().anyMatch(n -> n == winningTicket.bonusNumber);
    }

    public String toString() {
        return numbers.toString();
    }
}

