package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("Lotto는 6개의 숫자를 갖습니다.");
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public String createFormattedLotto() {
        return numbers.stream().map(String::valueOf)
                .collect(joining(", "));
    }
}
