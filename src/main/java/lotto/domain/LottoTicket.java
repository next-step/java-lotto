package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {
    static final long PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.of(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    LottoTicketResult checkWinning(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 숫자(%d)는 중복될 수 없습니다.", bonusNumber.getNumber()));
        }
        int matchCount = lottoNumbers.match(winningNumbers);
        boolean bonusMatch = lottoNumbers.getLottoNumbers().contains(bonusNumber);
        return new LottoTicketResult(matchCount, bonusMatch);
    }

    public static LottoTicket of(int... lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }
}
