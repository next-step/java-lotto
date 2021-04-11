package step2.domain;

import step2.utils.LottoNumberGenerator;

import java.util.List;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    private final List<Integer> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator){
        lottoNumbers = lottoNumberGenerator.generate();
    }

    public List<Integer> getNumbers(){
        return lottoNumbers;
    }
}
