package lotto;

import java.util.List;

public class WinningLotto {
    List<LottoNumber> value;

    public WinningLotto(List<LottoNumber> winningNumbers) {
        this.value = winningNumbers;
    }

    public List<LottoNumber> value() {
        return value;
    }
}
