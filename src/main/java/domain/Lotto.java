package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.type.LottoRankAmount;

public class Lotto {
    private LottoNumbers lottoNumber;
    private LottoRankAmount lottoRankAmount;

    public Lotto() {
        this.lottoNumber = new LottoNumbers();
    }

    public LottoRankAmount getLottoRankAmount() {
        return lottoRankAmount;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumber;
    }

}
