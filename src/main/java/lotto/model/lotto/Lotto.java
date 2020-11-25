package lotto.model.lotto;

import lotto.strategy.DrawingStrategy;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public abstract class Lotto {
    public final static int PRICE = 1000;
    protected LottoTicket numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public LottoTicket getMatchingNumberCount(LottoTicket inputNumbers, LottoNumber bonus) {
        LottoTicket matchNumbers = numbers.intersect(inputNumbers);

        int matchCount = matchNumbers.size();

        if(isSecond(inputNumbers, bonus, matchCount)){
            matchNumbers.add(bonus);
        }

        return matchNumbers;
    }

    public LottoTicket getLottoTicket() {
        return numbers;
    }

    private boolean isSecond(LottoTicket inputNumbers, LottoNumber bonus, int matchCount) {
        return matchCount == 5 && inputNumbers.contain(bonus);
    }
}
