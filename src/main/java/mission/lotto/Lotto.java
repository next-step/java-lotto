package mission.lotto;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;
    private String name;
    private KLottoRank kLottoRank;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numbers = lottoGenerator.generate();
        this.name = lottoGenerator.getName();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String getName() {
        return this.name;
    }

    public int matchCount(List<Integer> winNumbers) {
        return (int) numbers.stream()
                .distinct()
                .filter(winNumbers::contains)
                .count();
    }

    public KLottoRank checkRank(int matchCount) {
        return KLottoRank.find(matchCount);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
