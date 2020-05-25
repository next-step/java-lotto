package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private static final int LOTTO_LINE_PRICE = 1000;


    public LottoPaper sell(long price, List<LottoNums> manualLottoNums) {
        int autoCount = getTotalCount(price) - manualLottoNums.size();

        if (autoCount < 0) {
            throw new IllegalArgumentException("price is not enough");
        }

        List<LottoLine> lottoLines = new ArrayList<>();
        lottoLines.addAll(createManualLottoLines(manualLottoNums));
        lottoLines.addAll(createAutoLottoLines(autoCount));

        return new LottoPaper(lottoLines);
    }

    private List<LottoLine> createAutoLottoLines(int autoCount) {
        return Stream.generate(LottoLine::newAuto)
            .limit(autoCount)
            .collect(Collectors.toList());
    }

    private List<LottoLine> createManualLottoLines(List<LottoNums> manualLottoNums) {
        return manualLottoNums.stream()
            .map(LottoLine::newManual)
            .collect(Collectors.toList());
    }

    private int getTotalCount(long price) {
        return (int) (price / LOTTO_LINE_PRICE);
    }

}
