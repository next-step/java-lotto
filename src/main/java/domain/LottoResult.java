package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<LottoNumber> lottoResult;

    public LottoResult() {
        this.lottoResult = new ArrayList<>();
    }

    public LottoResult(List<LottoNumber> lottoNumbers) {
        this.lottoResult = lottoNumbers;
    }

    public static LottoResult fromIntegers(List<Integer> lottoIntegers) {
        LottoResult lottoResult = new LottoResult();
        for (int i = 0; i < lottoIntegers.size(); i++) {
            lottoResult.lottoResult.add(LottoNumber.from(lottoIntegers.get(i)));
        }
        return lottoResult;
    }

    public int size() {
        return lottoResult.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoResult;
    }

    public List<Integer> getLottoResult() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoResult) {
            int num = lottoNumber.getLottoNumber();
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }
}
