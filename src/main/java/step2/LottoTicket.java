package step2;

import java.util.HashSet;
import java.util.List;

public class LottoTicket {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Integer> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator){
        this.lottoNumberGenerator = lottoNumberGenerator;
        lottoNumbers = makeLottoNumbers();
    }

    private List<Integer> makeLottoNumbers(){
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        if(checkDuplicationNumbers(numbers)){
            throw new RuntimeException("로또 번호에 중복된 번호가 있습니다.");
        }
        return numbers;
    }

    private boolean checkDuplicationNumbers(List<Integer> numbers){
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        return hashSet.size()!= numbers.size();
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
