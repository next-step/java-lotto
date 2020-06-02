package study.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningNumbers;

    private WinningLotto(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(String[] winningNumbers) {
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers)
                                                .map(Integer::parseInt)
                                                .map(LottoNumber::new)
                                                .collect(Collectors.toList());

        return new WinningLotto(Lotto.of(winningNumberList));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return winningNumbers.getLottoNumbers();
    }
}
