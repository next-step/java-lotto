package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int PRICE = 1000;
    private final int FROM_INDEX = 0;
    private final int TO_INDEX = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>(new LottoNumber().getLottoNumberCache().values());

    public List<Lotto> buyLotto(int purchasePrice) {
        int buyCount = purchasePrice / this.PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    private Lotto createLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> extractionLottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);

        Collections.sort(extractionLottoNumbers);

        return new Lotto(extractionLottoNumbers);
    }
}
