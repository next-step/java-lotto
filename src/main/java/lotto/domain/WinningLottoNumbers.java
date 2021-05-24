package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public WinningLottoNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> winningLottoNumbers = new ArrayList<>();

        for (String lottoNumberStr : winningNumbers.split(",| ,")) {
            int lottoNumber = Integer.valueOf(lottoNumberStr);

            Lotto.throwIllegalArgumentException_lottoRange(lottoNumber);
            winningLottoNumbers.add(lottoNumber);

        }
        Lotto.throwIllegalArgumentException_lottoSize(winningLottoNumbers);
        this.winningLottoNumbers = winningLottoNumbers;

        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 볼은 중복되서는 안됩니다.");
        }

        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
