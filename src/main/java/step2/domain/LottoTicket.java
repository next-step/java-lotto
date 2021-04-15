package step2.domain;

import step2.LottoNumberGenerator;
import step2.utils.ValidationUtils;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1_000;
    private final LottoNumberGenerator lottoNumberGenerator;
    private List<Integer> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator){
        this.lottoNumberGenerator = lottoNumberGenerator;
        makeLottoNumbers();
    }

    private void makeLottoNumbers(){
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        ValidationUtils.validationNumbers(numbers);
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
