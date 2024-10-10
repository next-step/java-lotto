package model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    private List<List<Integer>> lottoNumbers;
    private LottoNumberGenerate lottoNumberGenerate;

    public LottoNumberGenerator(LottoNumberGenerate lottoNumberGenerate) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumberGenerate = lottoNumberGenerate;
    }

    public List<List<Integer>> run(int totalPrice, int priceOfALotto) {
        int cnt = totalPrice / priceOfALotto;

        this.lottoNumbers = lottoNumberGenerate.multiGenerate(0, cnt);
        return this.lottoNumbers;
    }
}
