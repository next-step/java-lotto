package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchNumbers(LottoTicket winningTicket) {
        return lottoNumbers.stream()
              .filter(lottoNumber -> findMatchNumber(winningTicket, lottoNumber))
              .collect(Collectors.toList()).size();
    }

    private boolean findMatchNumber(LottoTicket winningTicket, LottoNumber buyLottoNumber) {
        Optional<LottoNumber> matchNumber = winningTicket.lottoNumbers.stream()
              .filter(winningNumber -> buyLottoNumber.equals(winningNumber))
              .findFirst();

        return matchNumber.isPresent();
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(this.lottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}