package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public abstract class Lotto {
    public final static int PRICE = 1000;
    protected SortedSet<LottoNumber> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public SortedSet<LottoNumber> getMatchingNumberCount(SortedSet<LottoNumber> inputNumbers, LottoNumber bonus) {
        SortedSet<LottoNumber> matchNumbers = numbers.stream()
                .filter(inputNumbers::contains)
                .collect(Collectors.toCollection(TreeSet::new));

        int matchCount = matchNumbers.size();

        if(isSecond(inputNumbers, bonus, matchCount)){
            matchNumbers.add(bonus);
        }

        return matchNumbers;
    }

    public SortedSet<LottoNumber> getNumbers() {
        return numbers;
    }

    private boolean isSecond(SortedSet<LottoNumber> inputNumbers, LottoNumber bonus, int matchCount) {
        return matchCount == 5 && inputNumbers.contains(bonus);
    }

}
