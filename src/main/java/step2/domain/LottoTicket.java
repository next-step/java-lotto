package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket(){
        initializeLottoTicket();
        generateLottoNumbers();
    }

    private void initializeLottoTicket(){
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    private void generateLottoNumbers(){
        Collections.shuffle(lottoNumbers);
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < THE_NUMBER_OF_LOTTO_NUMBERS; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        lottoNumbers = lotto;
    }

    public List<Integer> getNumbers(){
        return lottoNumbers;
    }
}
