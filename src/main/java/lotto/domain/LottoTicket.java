package lotto.domain;

import java.util.List;

public class LottoTicket {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private List<LottoNumber> numbers;


    private LottoTicket(List<LottoNumber> numbers) {
        validateSize(numbers);

        this.numbers = numbers;
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

    public int getMatchCount(List<Integer> inputNumbers) {
        List<LottoNumber> lottoNumbers = LottoNumber.of(inputNumbers);
        return (int) numbers.stream().filter(lottoNumbers::contains).count();
    }

    public String toString() {
        return numbers.toString();
    }
}

