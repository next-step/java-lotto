package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<Lotto> lottoNumbers = new ArrayList<>();


    public void addLotto(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }


    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }


}
