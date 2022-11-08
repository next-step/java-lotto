package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket){
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket lottoMake(){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i= MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER + 1; i++){
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0,6));
    }

    public List<Integer> getTicket() {
        return lottoTicket;
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}
