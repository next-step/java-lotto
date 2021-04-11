package step2.utils;

import step2.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> numbers = initLottoList();
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LottoTicket.THE_NUMBER_OF_LOTTO_NUMBERS; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

    private List<Integer> initLottoList(){
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LottoTicket.LOTTO_MIN_NUMBER; i <= LottoTicket.LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}
