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

    // 보너스 볼이 포함되었을 때
    public ScoreType getScoreType(Lotto lottoAnswer, Bonus bonus) {
        Integer count = getScore(lottoAnswer);
        boolean isBonusContained = this.numbers.contains(bonus.getNumber());

        if (count.equals(5) && isBonusContained) {
            return ScoreType.BONUS;
        }
        return ScoreType.of(count, false);
    }

    private Integer getScore(Lotto lottoAnswer) {
        return Math.toIntExact(lottoAnswer.getNumbers()
                .stream()
                .filter(this.numbers::contains)
                .count());
    }
}
