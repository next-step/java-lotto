package lotto;

import java.util.*;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> lottoTicket;

    public LottoTicket() {
        lottoTicket = makeLottoNumbers();
    }

    public List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList = new ArrayList<>();
        for(int i = 0; i<45; i++){
            lottoNumberList.add(i+1);
        }
        Collections.shuffle(lottoNumberList);
        return lottoNumberList.subList(0,LOTTO_NUMBERS_SIZE);
    }

}
