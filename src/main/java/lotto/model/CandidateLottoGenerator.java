package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class CandidateLottoGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    public static LottoTicket generate(){
        List<LottoNumber> temp = new ArrayList<LottoNumber>();
        for (int i=1; i<MAX_LOTTO_NUMBER + 1; i++){
            temp.add(new LottoNumber(i));
        }
        return new LottoTicket(temp);
    }
}
