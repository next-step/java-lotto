package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int TOTAL_LOTTO_NUMBERS_COUNT = 6;

    private final Set<LottoNumber> lottoTicket;

    private LottoTicket(Set<LottoNumber> lottoTicket) {
        validate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers.stream()
                .map(lottoNumber -> LottoNumber.of(lottoNumber))
                .collect(Collectors.toCollection(TreeSet::new)));
    }

    public static LottoTicket of(Set<LottoNumber> lottoNumbers) {
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

    public int getCountOfMatch(LottoTicket compareLottoTicket) {
        return (int) lottoTicket.stream()
                .filter(lottoNumber -> compareLottoTicket.contains(lottoNumber))
                .count();
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
