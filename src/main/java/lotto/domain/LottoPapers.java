package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoPapers {
    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }
    
    public List<LottoPaper> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }

    public int getPapersSize() {
        return lottoPapers.size();
    }
}
