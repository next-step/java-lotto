package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoFactory {
    private static final String DELIMITER = ",";

    private WinningLottoFactory() {
    }

    public static WinningLotto create(String winningNumbersString) {
        return create(winningNumbersString, null);
    }

    public static WinningLotto create(String winningNumbersString, Integer bonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersString.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<LottoNumber> lottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validateWinningNumberAndBonusNumber(lottoNumbers, bonusNumber);

        return new WinningLotto(new LottoTicket(lottoNumbers), bonusNumber);
    }

    private static void validateWinningNumberAndBonusNumber(Set<LottoNumber> lottoNumbers, Integer bonusNumber) {
        if (bonusNumber != null && lottoNumbers.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다");
        }
    }
}
