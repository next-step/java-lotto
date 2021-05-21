package lotto.utils;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("입력받은 문자열 번호를 정수형 리스트로 생성 확인")
    @Test
    public void createLottoNumbers() {
        List<String> inputLottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(inputLottoNumbers);

        assertThat(lottoNumbers).containsExactly(LottoNumber.create(1)
                , LottoNumber.create(2)
                , LottoNumber.create(3)
                , LottoNumber.create(4)
                , LottoNumber.create(5)
                , LottoNumber.create(6));
    }

}
