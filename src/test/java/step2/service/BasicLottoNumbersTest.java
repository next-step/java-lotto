package step2.service;

import org.junit.jupiter.api.RepeatedTest;
import step2.vo.LottoNumber;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLottoNumbersTest {

    private BasicLottoNumbers basicLottoNumbers = new BasicLottoNumbers();

    @RepeatedTest(value = 10, name = "LottoNumber 6개 발생시키는 테스트")
    void pickSixNumbersTest() {
        Set<LottoNumber> lottoNumbers = basicLottoNumbers.pickSixNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }
}
