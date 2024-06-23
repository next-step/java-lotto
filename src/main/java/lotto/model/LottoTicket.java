package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int LOTTO_NUBERS_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this(lottoNumbers.stream()
                .map(number -> LottoNumber.of(number))
                .collect(Collectors.toSet()));
    }

    protected LottoTicket(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUBERS_SIZE) {
            throw new IllegalArgumentException("로또 티켓의 로또 숫자는 6개이어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int match(LottoTicket otherNumbers) {
        int matchCount = 0;
        for (LottoNumber number : lottoNumbers) {
            if (otherNumbers.getLottoNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
