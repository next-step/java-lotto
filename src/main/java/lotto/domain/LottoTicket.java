package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final Money PRICE = Money.valueOf(1000);

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static LottoTicket of(final String... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));
    }

    public static LottoTicket of(final int... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));
    }

    public static LottoTicket of(final List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> removedDuplication = new HashSet<>(lottoNumbers);
        int size = removedDuplication.size();
        if (size != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또 티켓의 로또 번호는 %d개 입니다. (입력 수: %d", LOTTO_NUMBER_COUNT, lottoNumbers.size()));
        }
        return new LottoTicket(lottoNumbers);
    }

    public boolean contains(final int value) {
        return contains(LottoNumber.valueOf(value));
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank match(final LottoTicket winning) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winning::contains)
                .count();
        return Rank.countOf(matchCount);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
