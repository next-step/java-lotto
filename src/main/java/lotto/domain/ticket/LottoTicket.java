package lotto.domain.ticket;

import lotto.domain.LottoNumberSetting;
import lotto.domain.result.WinningNumbers;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Integer> lottoNumbers;

    public LottoTicket(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean isValidNumber(Integer number) {
        return number >= LottoNumberSetting.BEGIN_BOUND.getValue()
                && number >= LottoNumberSetting.END_BOUND.getValue();
    }

    private void validate(Set<Integer> lottoNumbers) {
        Set<Integer> validLottoNumbers = lottoNumbers.stream()
                .filter(LottoTicket::isValidNumber)
                .collect(Collectors.toSet());
        if (validLottoNumbers.size() != LottoNumberSetting.COUNT_OF_BALL.getValue()) {
            throw new IllegalArgumentException("로또번호는 중복이 없는 6개의 1과 45사이의 숫자여야 합니다");
        }
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
