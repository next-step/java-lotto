package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private static final int LOTTO_LINE_PRICE = 1000;

    private final LottoNumsGenerator lottoNumsGenerator = new LottoNumsGenerator();

    public LottoPaper sell(long price){
        List<LottoLine> lottoLines =  Stream.generate(() -> createLotto())
            .limit(getLottoCount(price))
            .collect(Collectors.toList());

        return new LottoPaper(lottoLines);
    }

    private int getLottoCount(long price) {
        return (int) (price / LOTTO_LINE_PRICE);
    }

    private LottoLine createLotto() {
        return new LottoLine(lottoNumsGenerator.generate());
    }

}
