package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CandidateLottoNumbers {
    private final int LOTTO_DIGIT_SIZE = 6;
    private final int LOTTO_SUBLIST_FROM_INDEX = 0;
    private final int LOTTO_SUBLIST_TO_INDEX = LOTTO_DIGIT_SIZE;
    private List<LottoNumber> candidateLottoNumbers;

    public CandidateLottoNumbers(List<LottoNumber> candidateLottoNumbers) {
        this.candidateLottoNumbers = candidateLottoNumbers;
    }

    public LottoTicket getRandomLottoTicket(){
        Collections.shuffle(candidateLottoNumbers);
        //MEMO: sublist는 parent의 reference를 가짐
        return new LottoTicket(
                new ArrayList(candidateLottoNumbers.subList(LOTTO_SUBLIST_FROM_INDEX, LOTTO_SUBLIST_TO_INDEX))
        );
    }

}
