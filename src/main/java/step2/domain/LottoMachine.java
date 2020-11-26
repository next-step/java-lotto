package step2.domain;

import java.util.*;

public class LottoMachine {
    private final int PRICE = 1000;
    private static final List<Integer> TOTAL_NUMBERS = Arrays.asList(
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45);

    private Lotto createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(this.TOTAL_NUMBERS);
        Collections.shuffle(lottoNumbers);
        List<Integer> extractionLottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(extractionLottoNumbers);
        return new Lotto(extractionLottoNumbers);
    }

    public List<Lotto> buyLotto(int purchasPrice) {
        int buyCount = purchasPrice / this.PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(createLottoNumbers());
        }
        return lottoList;
    }
}
