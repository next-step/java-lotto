package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.error.exception.SizeExceedLottoNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    private LottoNumber[] values;

    @BeforeEach
    public void beforeEach() {
        values = LottoNumber.values();
    }

    @Test
    @DisplayName("LottoNumber는 1부터 45까지의 범위의 값만 가질수 있다")
    public void Lotto_Number_Should_Have_Values_1_To_45() {
        assertThat(values)
            .extracting(LottoNumber::getLottoNumber)
            .allSatisfy(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
    }

    @ParameterizedTest
    @ValueSource(ints = {-47, -1, 0, 46, 47})
    @DisplayName("LottoNumber가 1부터 45의 범위가 아닌 경우 예외가 발생한다")
    public void If_Lotto_Number_Not_In_range1_to_45_Occurs_Exception(int input) {
        assertThatThrownBy(() -> LottoNumber.fromInt(input))
            .isInstanceOf(SizeExceedLottoNumberException.class)
            .hasMessage("로또 번호는 1부터 45의 범위만 가능합니다. 입력값: " + input);
    }

    @Test
    @DisplayName("유효한 LottoNumber는를 입력받으면 LottoNumber는를 반환해야한다")
    public void If_Valid_Number_Should_Be_Returned_Lotto_Number() {
        int input = 10;

        LottoNumber lottoNumber = LottoNumber.fromInt(input);

        assertThat(lottoNumber).isEqualTo(LottoNumber.TEN);
    }

    @Test
    @DisplayName("자동 생성을 통해 생성된 LottoNumber의 크기는 6이어야 한다")
    public void Lotto_Numbers_Should_Size_6_When_Create_Auto() {
        List<LottoNumber> randomLottoNumbers = LottoNumber.createRandomLottoNumbers();

        assertThat(randomLottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("createRandomLottoNumbers를 수행해서 생성한 LottoNumbers는 길이가 6인 LottoNumbers를 반환해야한다")
    public void Lotto_Should_Return_Lotto_Numbers_With_Length_6_After_Creating_Random_Lotto_Numbers() {
        List<LottoNumber> randomLottoNumbers = LottoNumber.createRandomLottoNumbers();
        assertThat(randomLottoNumbers.size()).isEqualTo(6);
    }
}
