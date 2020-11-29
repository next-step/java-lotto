package lotto.model.lotto;


import lotto.strategy.DrawingStrategy;
import util.CommonUtils;

import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

public abstract class Lotto {
    private final static String NUMBERS_DELIMITER = ", ";

    private final static int SECOND_CANDIDATE_COUNT = 5;

    public final static int PRICE = 1000;

    protected SortedSet<LottoNumber> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public List<LottoNumber> intersect(Lotto inputLotto, LottoNumber bonus) {
        SortedSet<LottoNumber> inputNumbers = inputLotto.numbers;

        List<LottoNumber> matchingNumber = numbers.stream()
                .filter(inputNumbers::contains)
                .collect(Collectors.toList());

        if(isSecond(matchingNumber, inputNumbers, bonus)){
            matchingNumber.add(bonus);
        }

        return matchingNumber;
    }

    private boolean isSecond(List<LottoNumber> matchingNumber, SortedSet<LottoNumber> inputNumber, LottoNumber bonus) {
        return matchingNumber.size() == SECOND_CANDIDATE_COUNT &&
                (inputNumber.contains(bonus) || numbers.contains(bonus));
    }

    @Override
    public String toString() {
        return String.join(NUMBERS_DELIMITER, CommonUtils.sortedSetToArray(numbers));
    }
}
