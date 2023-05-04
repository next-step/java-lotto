package lotto;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numbers = lottoGenerator.generate();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private int matchCount(List<Integer> winNumbers) {
        return (int) numbers
                .stream()
                .distinct()
                .filter(winNumbers::contains).count();
    }

    private boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public KLottoRank checkRank(List<Integer> winNumbers, int bonus) {
        return KLottoRank.find(matchCount(winNumbers), hasBonus(bonus));
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
