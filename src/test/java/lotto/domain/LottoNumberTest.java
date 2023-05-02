package lotto.domain;

import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {
    @DisplayName("범위를 벗어난 숫자 입력시 예외가 발생한다")
    @Test
    public void rangeOutException() {
        //given
        int input = 46;
        //when
        //then
        assertThatThrownBy(() -> {
            new LottoNumber(input);
        }).isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("LottoNumber 숫자는 1~45 사이만 허용된다");
    }

    @DisplayName("범위 내 숫자 입력시 인스턴스가 생성된다")
    @Test
    public void rangeInGood() {
        //given
        int input = 45;
        //when
        LottoNumber lottoNumber = new LottoNumber(input);
        //then
        assertAll("",
                () -> assertThat(lottoNumber).as("인스턴스 생성에 성공했다").isNotNull(),
                () -> assertThat(lottoNumber.getLottoNumber()).as("인스턴스 생성에 성공했다").isEqualTo(input)
        );

    }

    @DisplayName("동등성 검증 - 숫자가 같으면 같은 인스턴스라고 인식한다")
    @Test
    public void equals() {
        //given
        //when
        LottoNumber lottoNumberA = new LottoNumber(1);
        LottoNumber lottoNumberB = new LottoNumber(1);
        //then
        assertEquals(lottoNumberA, lottoNumberB);
    }
}