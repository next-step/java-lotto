package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPapers {
    private List<Lotto> lottoPapers;

    public LottoPapers(int turn) {
        this.lottoPapers = new ArrayList<>();
        addLottosInPapers(turn);
    }

    private void addLottosInPapers(int turn) {
        for(int i = 0; i < turn; i++) {
            lottoPapers.add(new Lotto());
        }
    }

    public List<Lotto> getLottoPapers() {
        return this.lottoPapers;
    }

    public List<Lotto> putLottoPapers() {
        return this.getLottoPapers();
    }
}
