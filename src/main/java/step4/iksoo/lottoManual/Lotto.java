package step4.iksoo.lottoManual;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private List<LottoNo> luckyNumbers;

    Lotto() {
        this(new RandomNumberCreator().getLotto(LOTTO_SIZE));
    }

    Lotto(List<Integer> numbers) {
        this.luckyNumbers = sortLotto(solveDuplicated(convertToLottoNo(numbers)));
    }

    private List<LottoNo> convertToLottoNo(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNo(number))
                .collect(Collectors.toList());
    }

    private List<LottoNo> solveDuplicated(List<LottoNo> numbers) {
        int nonDuplicatedCount = (int) numbers.stream()
                .distinct()
                .count();

        if (nonDuplicatedCount < LOTTO_SIZE) {
            throw new IllegalArgumentException("숫자가 중복되어 입력되었습니다.");
        }

        return numbers;
    }

    private List<LottoNo> sortLotto(List<LottoNo> luckyNumbers) {
        return luckyNumbers.stream()
                .sorted(Comparator.comparing(LottoNo::getNumber))
                .collect(Collectors.toList());
    }

    public Rank checkNumberOfMatches(Lotto winNumbers, LottoNo bonusBall) {
        int countOfMatch = (int) luckyNumbers
                .stream()
                .filter(winNumbers::isContains)
                .count();
        return Rank.valueOf(countOfMatch, luckyNumbers.contains(bonusBall));
    }

    public boolean isContains(LottoNo number) {
        return this.luckyNumbers.contains(number);
    }

    public List<Integer> getLotto() {
        return this.luckyNumbers.stream()
                .map(lottoNo -> lottoNo.getNumber())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(luckyNumbers, lotto.luckyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(luckyNumbers);
    }
}
