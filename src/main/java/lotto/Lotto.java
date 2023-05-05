package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numbers = lottoGenerator.generate();
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    private int matchCount(List<Integer> winNumbers) {
//        int count = 0;
        List<LottoNumber> winLottoNumber = winNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        Set<LottoNumber> set = new HashSet<>(numbers);

        return (int) winLottoNumber.stream()
                .filter(set::contains)
                .count();
    }

    private boolean hasBonus(int bonusNumber) {
        return numbers.contains(LottoNumber.of(bonusNumber));
    }

    public KLottoRank checkRank(List<Integer> winNumbers, int bonus) {
        return KLottoRank.find(matchCount(winNumbers), hasBonus(bonus));
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
