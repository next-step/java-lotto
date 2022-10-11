package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoGame(){
    }

    public static LottoGame newInstance() {
        return new LottoGame();
    }

    public List<LottoNumber> playLotto(int purchaseCount){
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(LottoNumber.newInstance());
        }

        return lottoNumbers;
    }
}
