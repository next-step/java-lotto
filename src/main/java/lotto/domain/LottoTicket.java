package lotto.domain;

import lotto.strategy.LottoMakeStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> lottoTicket;

    public LottoTicket(LottoMakeStrategy lottoMakeStrategy){
        this.lottoTicket = lottoMakeStrategy.valueOf();
    }

    public LottoTicket(List<Integer> numbers){
        this.lottoTicket = valueOf(numbers);
    }

    public List<LottoNumber> valueOf(List<Integer> numbers){
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }


    public Reward lottoNumberMatch(WinningNumbers winningNumbers){
        return winningNumbers.winningLottoMatch(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
