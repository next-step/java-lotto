package lotto.domain;

import lotto.util.LottoNumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPapers {
    private final List<LottoPaper> papers;

    public LottoPapers(int paperCount) {
        papers = makeAutoLottoNums(paperCount);
    }

    private List<LottoPaper> makeAutoLottoNums(Integer paperCount) {
        return IntStream.range(0, paperCount)
                .mapToObj(value -> new LottoPaper(getAutoLottoNums()))
                .collect(Collectors.toList());
    }

    private List<LottoNum> getAutoLottoNums() {
        return LottoNumberUtil.getAutoLottoNums();
    }

    public List<LottoPaper> getPapers() {
        return Collections.unmodifiableList(papers);
    }

    public int getPapersSize() {
        return papers.size();
    }
}
