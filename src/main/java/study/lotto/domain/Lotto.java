package study.lotto.domain;

import study.lotto.util.LottoUtil;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto autoGenerate() {
        List<Integer> autoNumbers = LottoUtil.generateRandomNumber();
        autoNumbers.sort(Integer::compareTo);
        return new Lotto(autoNumbers);
    }

    public static Lotto generate(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getScore(Lotto result) {
        return Math.toIntExact(result.getNumbers()
                .stream()
                .filter(this.numbers::contains)
                .count());
    }
}
