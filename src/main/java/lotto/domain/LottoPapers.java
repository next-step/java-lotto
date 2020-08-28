package lotto.domain;

import lotto.util.LottoNumberUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPapers {
    private static final Integer LOTTO_PRICE = 1000;
    private static final String LOTTO_PAPER_JOINING_DELIMITER = "\n";
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

    private List<Integer> getAutoLottoNums() {
        return LottoNumberUtil.getAutoLottoNums();
    }

    public List<LottoPaper> getPapers() {
        return papers;
    }

    public Integer getPapersCount() {
        return papers.size();
    }

    public String getPaperNumbersToString() {
        return papers.stream()
                .map(LottoPaper::getLottoNumbers).map(String::valueOf)
                .collect(Collectors.joining(LOTTO_PAPER_JOINING_DELIMITER));
    }
}
