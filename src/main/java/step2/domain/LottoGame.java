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

    public void addLotto(LottoNumber lottoNumber){
        this.lottoNumbers.add(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
