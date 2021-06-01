package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class CandidateLottoGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_LIMIT = MAX_LOTTO_NUMBER + 1;

    public static CandidateLottoNumbers generate(){
        List<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();
        for (int i=MIN_LOTTO_NUMBER; i<MAX_LOTTO_LIMIT; i++){
            lottoNumbers.add(new LottoNumber(i));
        }
        return new CandidateLottoNumbers(lottoNumbers);
    }
}
