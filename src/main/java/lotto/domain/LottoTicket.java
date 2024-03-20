package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket() {
        this(LottoNumberGenerator.generate());
    }

    public LottoPrize getPrize(LottoTicket winLottoTicket) {
        int matchCount = count(winLottoTicket.numbers);
        return LottoPrize.lookup(matchCount);
    }

    private int count(List<LottoNumber> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public List<LottoNumber> get() {
        return this.numbers;
    }

}
