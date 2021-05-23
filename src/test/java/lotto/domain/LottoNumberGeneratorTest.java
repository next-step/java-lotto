package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("입력받은 문자열 번호를 통하여 로또티켓과 해당 티켓에 로또번호가 존재하는지 확인")
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
