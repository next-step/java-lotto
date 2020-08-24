package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;

import java.util.stream.Collectors;

public class LottoNumberTest {
    @Test
    void lott_shuffle() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.creatLottoNumber();
        lottoNumber.getLottoNumbers().stream().collect(Collectors.toList()).forEach(System.out::println);
    }
}
