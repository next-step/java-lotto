package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class LottoTicket {

    private final int INCREMENT_WHEN_MATCH = 1;
    private final int INCREMENT_WHEN_NO_MATCH = 0;
    private final int NUMBER_COUNT = 6;


    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) throws IllegalArgumentException {
        checkNumberCount(numbers);
        checkDuplicated(numbers);
        this.numbers = numbers;
    }

    private void checkDuplicated(List<LottoNumber> numbers) {
        HashSet<LottoNumber> collect = new HashSet<>(numbers);
        if (collect.size() < NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberCount(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int countOfNumbers() {
        return numbers.size();
    }

    public MatchStatus matchingStatusWith(WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (LottoNumber number : numbers) {
            matchCount += increaseCountWhenMatch(number, winningNumbers);
        }
        return MatchStatus.findStatusByMatchCount(matchCount);
    }

    private int increaseCountWhenMatch(LottoNumber number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            return INCREMENT_WHEN_MATCH;
        }
        return INCREMENT_WHEN_NO_MATCH;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : numbers) {
            stringBuilder.append(lottoNumber.number());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
