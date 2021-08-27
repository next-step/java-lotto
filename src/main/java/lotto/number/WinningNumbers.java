package lotto.number;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        this.winningNumbers = lottoNumbers;
    }

    public static WinningNumbers getInstanceByInt(List<Integer> lottoNumbers) {
        return new WinningNumbers(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    List<LottoNumber> getValue() {
        return winningNumbers;
    }

}
