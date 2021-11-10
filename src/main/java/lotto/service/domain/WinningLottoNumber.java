package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;

public class WinningLottoNumber {
    private final List<LottoNumber> winningLottoNumbers;

    private WinningLottoNumber(List<LottoNumber> winningLottoNumbers) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningLottoNumbers는 필수값 입니다.");

        this.winningLottoNumbers = winningLottoNumbers;
    }

    public static WinningLottoNumber from(List<LottoNumber> numbers) {
        return new WinningLottoNumber(numbers);
    }

    public Integer getMatchingCount(LottoTicket lottoTicket) {
        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::isContains)
                .count();
    }
}
