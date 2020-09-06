package lotto.domain;

import lotto.context.Error;
import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final int DEFAULT_RANGE_START = 0;

    private final LottoPapers manualPapers;
    private final LottoPapers autoPapers;

    public LottoStore(List<String> autoTexts, int paperCount) {
        manualPapers = new LottoPapers(makeManualLottoNums(autoTexts));
        autoPapers = new LottoPapers(makeAutoLottoNums(paperCount - manualPapers.getPapersSize()));
        validMaxLotto(paperCount);
    }

    private void validMaxLotto(int paperCount) {
        if ((getAutoCount() + getManuaCount()) > paperCount) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_MAX_OVER.getMsg());
        }
    }

    private List<LottoPaper> makeManualLottoNums(List<String> autoTexts) {
        if (autoTexts == null) {
            return new ArrayList<>();
        }
        List<LottoPaper> lottoPapers = new ArrayList<>();
        for (String text : autoTexts) {
            lottoPapers.add(new LottoPaper(text));
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
        return LottoPapers.makeLottoPapers(new LottoPapers[]{manualPapers, autoPapers});
    }

    public int getManuaCount() {
        return manualPapers.getPapersSize();
    }

    public int getAutoCount() {
        return autoPapers.getPapersSize();
    }


}
