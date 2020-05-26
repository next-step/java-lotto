package lotto.domain.ticket;

import lotto.domain.LottoNumberSetting;
import lotto.domain.result.LottoPrize;
import lotto.domain.result.WinningTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Integer> lottoNumbers;

    public LottoTicket(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<Integer> lottoNumbers) {
        Set<Integer> validLottoNumbers = lottoNumbers.stream()
                .filter(LottoTicket::isValidNumber)
                .collect(Collectors.toSet());
        if (validLottoNumbers.size() != LottoNumberSetting.COUNT_OF_BALL.getValue()) {
            throw new IllegalArgumentException("로또번호는 중복이 없는 6개의 1과 45사이의 숫자여야 합니다");
        }
    }

    private static boolean isValidNumber(Integer number) {
        return number >= LottoNumberSetting.BEGIN_BOUND.getValue()
                && number <= LottoNumberSetting.END_BOUND.getValue();
    }

    public LottoPrize calculateLottoPrize(WinningTicket winningTicket) {
        int matchCount = Math.toIntExact(lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count());
        boolean matchBonus = lottoNumbers.stream()
                .anyMatch(winningTicket::matchBonus);

        return LottoPrize.findByMathCount(matchCount, matchBonus);
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return String.valueOf(sortedLottoNumbers);
    }
}
