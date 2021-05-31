package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CandidateLottoNumbersTest {

    @Test
    void 생성테스트(){
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i=0; i<45; i++){
            numbers.add(new LottoNumber(i));
        }
        CandidateLottoNumbers candidateLottoNumbers = new CandidateLottoNumbers(numbers);

    }

}