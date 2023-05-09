package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

public class LottoFactoryTest {

    @Test
    void 수동입력_입력숫자_초과시_체크() {
        Assertions.assertThatThrownBy(()->LottoFactory.createManual("7, 6, 5, 4, 3, 2, 1")).isInstanceOf(InvalidParameterException.class);
    }

    @Test
    void 수동입력_오름차순으로_정렬된지_체크() {
        List<LottoNumber> lottoNumbers = LottoFactory.createManual("6, 5, 4, 3, 2, 1");

        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            Assertions.assertThat(lottoNumbers.get(i).compareTo(lottoNumbers.get(i+1)) < 0).isTrue();
        }
    }

    @Test
    void 수동입력_사이즈_테스트() {
        List<LottoNumber> lottoNumbers = LottoFactory.createManual("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 자동입력_오름차순으로_정렬된지_체크() {
        List<LottoNumber> lottoNumbers = LottoFactory.createRandom();

        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            Assertions.assertThat(lottoNumbers.get(i).compareTo(lottoNumbers.get(i+1)) < 0).isTrue();
        }
    }

    @Test
    void 자동입력_사이즈_테스트() {
        List<LottoNumber> lottoNumbers = LottoFactory.createRandom();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }


}
