package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static List<Lotto> lottoNumbers;

    public Lottos() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoNumbers.add(lotto);
    }

    public void addAll(List<Lotto> lotto) {
        lottoNumbers.addAll(lotto);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public LottoResult match(WinningLotto winningLottoNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoNumbers){
            LottoRank lottoRank  = winningLottoNumber.findRank(lotto);
            lottoResult.add(lottoRank);
        }
        return lottoResult;
    }
}
