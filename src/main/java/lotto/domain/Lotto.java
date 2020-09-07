package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Lotto {

    LottoNumbers lottoNums;
    Rank rank;

    private Lotto(LottoNumbers lottoNums) {
        this.lottoNums = lottoNums;
    }

    public static Lotto of(ArrayList<Integer> lottoNums) {
        return new Lotto(LottoNumbers.create(lottoNums));
    }

    public void findLottoRank(ArrayList<Integer> winningLottoNumbers) {
        this.rank = lottoNums.getLottoRank(winningLottoNumbers);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Lotto lotto = (Lotto) obj;
        return lottoNums == ((Lotto) obj).lottoNums;
    }
}
