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

    public Rank calculateRank(LottoTicket winNumbers, LottoNumber bonus) {
        int matchCount = calculateMatchCount(winNumbers);
        boolean bonusMatch = contains(bonus);

        return Rank.findByMatchCountAndBonusMatch(matchCount, bonusMatch);
    }

    private int calculateMatchCount(LottoTicket winNumbers) {
        return (int) numbers.stream()
                .filter(number -> winNumbers.contains(number))
                .count();
    }

    public boolean contains(LottoNumber num) {
        return (numbers.contains(num));
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
