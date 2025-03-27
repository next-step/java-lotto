package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = List.copyOf(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Rank checkLottoRank(List<LottoNumber> winningNumbers) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return Rank.getRankByMatchCount(matchCount);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public String getNumbersAsString() {
        return "[" + lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
