package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int PRICE = 1000;
    private List<LottoNumber> lottoNumbers;

    public List<Lotto> buyLotto(int purchasePrice) {
        int buyCount = purchasePrice / this.PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    private Lotto createLotto() {
        lottoNumbers = new ArrayList<>();

        for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
            int lottoNumber = (int)(Math.random() * 45) + 1;
            System.out.println(lottoNumber);
            lottoNumbers.add(LottoNumber.of(lottoNumber));
        }

        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
