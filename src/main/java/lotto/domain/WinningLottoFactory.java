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
        List<Integer> winningNumbers = Arrays.stream(winningNumbersString.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<LottoNumber> lottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        return new WinningLotto(new LottoTicket(lottoNumbers));
    }
}

