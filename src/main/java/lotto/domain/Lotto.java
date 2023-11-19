package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = LottoGenerator.generate();
    }

    public Lotto(List<Integer> list) {
        this.numbers = LottoGenerator.generate(list);
    }

    public LottoResult match(Lotto winningLotto) {
        int matchCount = (int) numbers.stream()
                .filter(number -> winningLotto.numbers.contains(number))
                .count();
        return LottoResult.findResult(matchCount);
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

}
