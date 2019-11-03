package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private List<Lotto> lottoPapers;

    public LottoPaper() {
        this.lottoPapers = new ArrayList<>();
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }

    public void applyLotto(Lotto lotto) {
        this.lottoPapers.add(lotto);
    }
    
    public void checkLottoGrade(int[] winLotto) {
        for (Lotto lotto : lottoPapers) {
            lotto.checkNumber(winLotto);
        }
    }
}
