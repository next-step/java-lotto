package step2;

import step2.utils.ValidationUtils;

import java.util.List;

public class LottoTicket {
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
