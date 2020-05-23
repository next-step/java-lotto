package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private static final int LOTTO_LINE_PRICE = 1000;

    private final LottoNumsGenerator lottoNumsGenerator = new LottoNumsGenerator();

    public LottoPaper sell(long price) {
       return this.sell(price, Collections.emptyList());
    }

    public LottoPaper sell(long price, List<LottoNums> manualLottoNums) {
        int autoCount = getTotalCount(price) - manualLottoNums.size();

        if(autoCount < 0){
            throw new IllegalArgumentException("price is not enough");
        }

        List<LottoLine> lottoLines = new ArrayList<>();
        lottoLines.addAll(createManualLottoLines(manualLottoNums));
        lottoLines.addAll(createAutoLottoLines(autoCount));

        return new LottoPaper(lottoLines);
    }

    private List<LottoLine> createAutoLottoLines(int autoCount) {
        return Stream.generate(() -> new LottoLine(lottoNumsGenerator.generate(), true))
            .limit(autoCount)
            .collect(Collectors.toList());
    }

    private List<LottoLine> createManualLottoLines(List<LottoNums> manualLottoNums) {
        return manualLottoNums.stream()
            .map(lottoNums -> new LottoLine(lottoNums, false))
            .collect(Collectors.toList());
    }

    private int getTotalCount(long price) {
        return (int) (price / LOTTO_LINE_PRICE);
    }

}
