package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int PRICE = 1000;
    private static final List<Integer> lottoNumbers;
    private static final int LOTTO_NUMBERS_START_NUMBER = 1;
    private static final int LOTTO_NUMBERS_END_NUMBER = 45;
    private final int FROM_INDEX = 0;
    private final int TO_INDEX = 6;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_NUMBERS_START_NUMBER, LOTTO_NUMBERS_END_NUMBER)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    private Lotto createLottoNumbers() {
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
