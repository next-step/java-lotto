package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers {

    private int bonusNumber;

    public WinningNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
    }
}
