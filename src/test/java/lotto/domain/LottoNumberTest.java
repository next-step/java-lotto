package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    @DisplayName("로또번호 반환 성공 테스트")
    public void getLottoNumberSuccess(int number) {
        assertThat(LottoNumber.valueOf(LottoNumber.getInstance(number))).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("로또번호 범위에 벗어난 경우 반환 실패 테스트")
    public void getLottoNumberFail(int number) {
        assertThatExceptionOfType(InvalidLottoNumbersException.class)
                .isThrownBy(() -> {
                    LottoNumber.getInstance(number);
                });
    }

    @Test
    @DisplayName("주어진 사이즈 만큼의 로또번호 리스트 반환 성공 테스트")
   public void getRandomListUnique() {
        int lottoSize = 6;

        assertThat(LottoNumber.getRandomListInstance(lottoSize)).hasSize(lottoSize);
    }

}
