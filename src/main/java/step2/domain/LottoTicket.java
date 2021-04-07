package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket(){
        initLottoTicket();
        lottoGenerator();
    }

    private void initLottoTicket(){
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    private void lottoGenerator(){
        Collections.shuffle(lottoNumbers);
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        lottoNumbers = lotto;
    }

    public List<Integer> getNumbers(){
        return lottoNumbers;
    }
}
