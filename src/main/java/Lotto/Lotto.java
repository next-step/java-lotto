package Lotto;

import java.util.List;

public class Lotto {
    private final LotterNumbers lottoNumbers;
    public static int LOTTO_COUNT = 6;

    public Lotto(LotterNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto of(LotterNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int compareNumbers(List<Integer> userNumbers) {

        int cnt = 0;

        for (int i = 0; i < Lotto.LOTTO_COUNT; i++) {
            for (int j = 0; j < Lotto.LOTTO_COUNT; j++) {
                if (lottoNumbers.getLottoNumbers().get(i) == userNumbers.get(j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
