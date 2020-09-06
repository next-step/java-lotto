package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPapers {
    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public static LottoPapers makeAll(LottoPapers... lottoPapersArray) {
        List<LottoPaper> papers = new ArrayList<>();
        for (int i = 0; i < lottoPapersArray.length; i++) {
            papers.addAll(lottoPapersArray[i].getLottoPapers());
        }
        return new LottoPapers(papers);
    }
    
    public List<LottoPaper> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }

    public int getPapersSize() {
        return lottoPapers.size();
    }
}
