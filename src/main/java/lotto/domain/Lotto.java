package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(convertToLottoNumber(numbers));
        this.rank = Rank.PENDING;
    }

    public Lotto(Rank rank) {
        this.numbers = new ArrayList<>();
        this.rank = rank;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public void determineLottoResult(List<LottoNumber> winningNumbers) {
        int matchCount = 0;

        for (LottoNumber number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        rank = Rank.getRankByMatchCount(matchCount);
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Rank getRank() {
        return rank;
    }

    public int getPrize() {
        return rank.getPrize();
    }
}
