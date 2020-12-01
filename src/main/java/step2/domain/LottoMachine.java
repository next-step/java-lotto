package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int PRICE = 1000;
    private static final List<Integer> lottoNumbers;

    static {
        final int LOTTO_NUMBERS_START_NUMBER = 1;
        final int LOTOO_NUMBERS_END_NUMBER = 45;

        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_NUMBERS_START_NUMBER, LOTOO_NUMBERS_END_NUMBER)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    private Lotto createLottoNumbers() {
        final int FROM_INDEX = 0;
        final int TO_INDEX = 6;

        Collections.shuffle(lottoNumbers);
        List<Integer> extractionLottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        Collections.sort(extractionLottoNumbers);
        return new Lotto(extractionLottoNumbers);
    }

    public List<Lotto> buyLotto(int purchasePrice) {
        int buyCount = purchasePrice / this.PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(createLottoNumbers());
        }
        return lottoList;
    }
}
