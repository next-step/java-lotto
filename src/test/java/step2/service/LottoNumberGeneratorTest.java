package step2.service;

import org.junit.jupiter.api.RepeatedTest;
import step2.vo.LottoNumber;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @RepeatedTest(value = 10, name = "LottoNumber 6개 발생시키는 테스트")
    void pickSixNumbersTest() {
        Set<LottoNumber> lottoNumbers = LottoNumberGenerator.generateSixNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }
}
