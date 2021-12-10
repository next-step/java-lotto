package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers) {
        this(new LottoNumbers(
                lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())));
    }

    public static List<Lotto> buyLotto(Money money) {
        return IntStream.range(0, money.getBuyableLottoCount())
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public LottoNumbers getLottoNumbers() {
        return numbers;
    }

    public Rank getLottoRank(LottoNumbers winningNumbers) {
        return this.numbers.getRank(winningNumbers);
    }
}
