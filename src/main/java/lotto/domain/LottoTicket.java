package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private static final int TOTAL_LOTTO_NUMBERS_COUNT = 6;

    private final Set<LottoNumber> lottoTicket;

    private LottoTicket(Set<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket of(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != TOTAL_LOTTO_NUMBERS_COUNT) {
            throw new InvalidLottoNumberCountException();
        }
    }

    public Set<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableSet(lottoTicket);
    }

    public int size() {
        return lottoTicket.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoTicket.contains(lottoNumber);
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

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoTicket +
                '}';
    }

}
