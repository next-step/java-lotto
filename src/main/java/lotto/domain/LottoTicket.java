package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    static private String DELIMITER_NUMBERS = ", ";

    private List<Integer> ticket;

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자는 6개이여야 합니다.");
        }

        Collections.sort(numbers);

        this.ticket = numbers;
    }

    public static LottoTicket of(String lottoNumbers) {
        String[] rawNumbers = lottoNumbers.split(DELIMITER_NUMBERS);
        List<Integer> numbers = Arrays.stream(rawNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return new LottoTicket(numbers);
    }

    public LottoWin checkWin(LottoTicket winner, int bonusBall) {
        int numOfCorrect = correctWith(winner);
        boolean hasBonus = hasBonus(bonusBall);

        return LottoWin.valueOf(numOfCorrect, hasBonus);
    }

    public int correctWith(LottoTicket another) {
        int result = 0;
        for (Integer number : ticket) {
            result += another.oneIfHas(number);
        }

        return result;
    }

    public int oneIfHas(int number) {
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