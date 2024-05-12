package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumbers> lotto;

    public Lotto(int count, LottoGenerator lottoGenerator){
        List<LottoNumbers> lotto = new ArrayList<>();

        for(int i = 0; i < count; i++){
            lotto.add(new LottoNumbers(lottoGenerator.randomNumber()));
        }

        this.lotto = lotto;
    }

    public Lotto(List<LottoNumbers> lotto){
        this.lotto = lotto;
    }

    public List<LottoNumbers> lotto() { return lotto; }

}
