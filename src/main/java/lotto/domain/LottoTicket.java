package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static String DELIMITER_NUMBERS = ", ";

    private List<LottoNumber> ticket;

    public LottoTicket(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자는 6개이여야 합니다.");
        }

        Collections.sort(numbers);

        this.ticket = numbers;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.stream()
                .map(numberInt -> new LottoNumber(numberInt))
                .collect(Collectors.toList());

        return new LottoTicket(numbers);
    }

    public static LottoTicket of(String lottoNumbers) {
        String[] rawNumbers = lottoNumbers.split(DELIMITER_NUMBERS);
        List<Integer> numbers = Arrays.stream(rawNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return of(numbers);
    }

    public LottoWin checkWin(LottoWinner winner) {
        int numOfCorrect = winner.correctWith(this);
        boolean hasBonus = winner.hasBonus(this);

        return LottoWin.valueOf(numOfCorrect, hasBonus);
    }

    public int oneIfHas(LottoNumber number) {
        return this.ticket.contains(number) ? 1 : 0;
    }

    public boolean hasBonus(int bonusBall) {
        return this.oneIfHas(bonusBall) == 1;
    }

    public List<Integer> getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket1 = (LottoTicket) o;
        return Objects.equals(ticket, ticket1.ticket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ticket);
    }
}