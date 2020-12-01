package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int PRICE = 1000;
    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    private Lotto createLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> extractionLottoNumbers = lottoNumbers.subList(0, 6);
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
