package lotto.domain;

import java.util.List;

public class LottoTicket {

    private List<LottoNumber> numbers;

    LottoTicket() {
        this(new NumberGenerator().generateNumbers());
    }

    LottoTicket(String text) {
        this(new NumberGenerator().generateNumbers(text));
    }

    private LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Rank calculateRank(WinTicket winTicket) {
        int matchCount = calculateMatchCount(winTicket);
        boolean bonusMatch = calculateBonusMatch(winTicket);

        return Rank.findByMatchCountAndBonusMatch(matchCount, bonusMatch);
    }

    private int calculateMatchCount(WinTicket winTicket) {
        return (int) numbers.stream()
                .filter(number -> winTicket.winTicketContains(number))
                .count();
    }

    private boolean calculateBonusMatch(WinTicket winTicket) {
        return (numbers.stream()
                .filter(number -> winTicket.bonusContains(number))
                .count()
                > 0);
    }

    public boolean contains(LottoNumber num) {
        return (numbers.contains(num));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
