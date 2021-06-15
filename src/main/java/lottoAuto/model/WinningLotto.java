package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningLottoNumbers;
    private int bonusBall;

    public WinningLotto(List<Integer> winningLottoNumbers,int bonusBall){
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getWinningLottoNumbers() {
        return Collections.unmodifiableList(winningLottoNumbers);
    }
}
