package lotto.domian;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumber;

    private LottoTicket(List<LottoNumber> lottoNumbers){
        this.lottoNumber = lottoNumbers.stream()
                            .sorted()
                            .collect(Collectors.toList());
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers){
        return new LottoTicket(lottoNumbers);
    }

    public int countMatchingNumbers(WinnerNumber winnerNumbers){
        return (int) this.lottoNumber.stream()
                .filter(winnerNumbers::containsLottoNumber)
                .count();
    }

    public List<LottoNumber> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
