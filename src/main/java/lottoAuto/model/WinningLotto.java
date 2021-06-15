package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private List<Lotto> winningLottoNumbers;

    public WinningLotto(List<Lotto> winningLottoNumbers){
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public List<Lotto> getWinningLottoNumbers() {
        return Collections.unmodifiableList(winningLottoNumbers);
    }
}
