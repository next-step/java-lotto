package lotto.domain;

import java.util.*;

public class LottoTicket {

    public static final Money PRICE = Money.valueOf(1000);

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(final Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static LottoTicket of(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> removedDuplication = new LinkedHashSet<>(lottoNumbers);
        int size = removedDuplication.size();
        if (size != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또 티켓의 로또 번호는 %d개 입니다. (입력 수: %d", LOTTO_NUMBER_COUNT, size));
        }
        return new LottoTicket(removedDuplication);
    }

    public boolean contains(final int value) {
        return contains(LottoNumber.valueOf(value));
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public int match(final LottoTicket other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }
}
