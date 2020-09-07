package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPapers {
    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public LottoPapers addAll(LottoPapers lottoPapers) {
        List<LottoPaper> papers = new ArrayList<>();
        papers.addAll(this.getLottoPapers());
        papers.addAll(lottoPapers.getLottoPapers());
        return new LottoPapers(papers);
    }
    
    public List<LottoPaper> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }

    public int getPapersSize() {
        return lottoPapers.size();
    }
}
