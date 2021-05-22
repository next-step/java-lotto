package lotto;

import java.util.List;

public class LottoTicket {

    private final int INCREMENT_WHEN_MATCH = 1;
    private final int INCREMENT_WHEN_NO_MATCH = 0;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
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
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
