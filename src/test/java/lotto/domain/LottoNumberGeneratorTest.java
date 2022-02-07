package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void 로또생성() {
        List<LottoNumber> lottoNumbers = new LottoNumberGenerator().generate();
        for(int i =0; i< lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i).getLottoNumber());
        }
    }
}
