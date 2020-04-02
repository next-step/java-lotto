package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoTicket {
    static final long PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.of(lottoNumbers);
    }

    private LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    LottoTicketResult checkWinning(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 숫자(%d)는 중복될 수 없습니다.", bonusNumber.getNumber()));
        }
        int matchCount = lottoNumbers.match(winningNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return new LottoTicketResult(matchCount, bonusMatch);
    }

    static LottoTicket of(int... lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    static LottoTicket ofForm(LottoTicketForm lottoTicketForm) {
        return new LottoTicket(lottoTicketForm.getLottoNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
