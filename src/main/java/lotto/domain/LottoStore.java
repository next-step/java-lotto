package lotto.domain;

import lotto.context.Error;
import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final String TEXT_SPLIT_DIVISION = ",";
    private static final int DEFAULT_RANGE_START = 0;

    private final List<LottoPaper> manualPapers;
    private final List<LottoPaper> autoPapers;

    public LottoStore(List<String> autoTexts, int paperCount) {
        manualPapers = makeManualLottoNums(autoTexts);
        autoPapers = makeAutoLottoNums(paperCount - manualPapers.size());
        validMaxLotto(paperCount);
    }

    private void validMaxLotto(int paperCount) {
        if ((getAutoCount() + getManuaCount()) > paperCount) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_MAX_OVER.getMsg());
        }
    }

    private List<LottoPaper> makeManualLottoNums(List<String> autoTexts) {
        if (autoTexts == null) return new ArrayList<>();
        List<LottoPaper> lottoPapers = new ArrayList<>();
        for (String text : autoTexts) {
            lottoPapers.add(new LottoPaper(Arrays.stream(text.split(TEXT_SPLIT_DIVISION))
                    .map(String::trim)
                    .map(s -> LottoNum.of(s))
                    .collect(Collectors.toList())));
        }
        return lottoPapers;
    }

    private List<LottoPaper> makeAutoLottoNums(Integer paperCount) {
        return IntStream.range(DEFAULT_RANGE_START, paperCount)
                .mapToObj(value -> new LottoPaper(makeAutoLottoNums()))
                .collect(Collectors.toList());
    }

    private List<LottoNum> makeAutoLottoNums() {
        return LottoNumberUtil.getAutoLottoNums();
    }

    public LottoPapers makeLottoPapers() {
        List<LottoPaper> papers = new ArrayList<>();
        papers.addAll(manualPapers);
        papers.addAll(autoPapers);
        return new LottoPapers(papers);
    }

    public int getManuaCount() {
        return manualPapers.size();
    }

    public int getAutoCount() {
        return autoPapers.size();
    }


}
