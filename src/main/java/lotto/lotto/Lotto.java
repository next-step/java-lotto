package lotto.lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.ui.Command;

public class Lotto {
    private static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers = new HashSet<>();

    public void addNumber(LottoNumber lottoNumber) {
        if (!isContain(lottoNumber)) {
            numbers.add(lottoNumber);
        }
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    public void retainAll(Answer answer) {
        numbers.retainAll(answer.numbers());
    }

    public int answerCount() {
        return numbers.size();
    }

    public String numbersToString() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(Command.NUMBER_DELIMITER));
    }

    private boolean isContain(LottoNumber number) {
        return numbers.stream().anyMatch(item -> item.equals(number));
    }
}
