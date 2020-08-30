package lotto.domain;

import lotto.util.LottoNumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPapers {
    private static final Integer LOTTO_PRICE = 1000;
    private final List<LottoPaper> papers;

    public LottoPapers(Integer inputMoney) {
        papers = makeAutoLottoNums(inputMoney);
    }

    private List<LottoPaper> makeAutoLottoNums(Integer inputMoney) {
        return IntStream.range(0, paperCount(inputMoney))
                .mapToObj(value -> new LottoPaper(getAutoLottoNums()))
                .collect(Collectors.toList());
    }

    private Integer paperCount(Integer inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }

    private List<LottoNum> getAutoLottoNums() {
        return LottoNumberUtil.getAutoLottoNums();
    }

    public List<LottoPaper> getPapers() {
        return Collections.unmodifiableList(papers);
    }

    public WinningTable makeWinningTable(List<Integer> winningNumbers) {
        WinningTable winningTable = new WinningTable();
        papers.stream()
                .forEach(lottoPaper -> {
                    winningTable.setAutoIncrementMatchCountResult(lottoPaper.getMatchCount(winningNumbers));
        });
        return winningTable;
    }
}
