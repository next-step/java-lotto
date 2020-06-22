package lotto.domain;

import calculator.ParserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp(){
        lottoNumber = new LottoNumber("2");
    }

    @DisplayName("검증을 통해서 만들어진 숫자 반환")
    @Test
    void getNumberWithSuccess() {
        int number = lottoNumber.getNumber();
        assertThat(number).isEqualTo(2);
    }

    @DisplayName("로또 숫자 범위를 초과하는 객체 생성시 에러 발생")
    @Test
    void getNumberWithErrorGrater() {
        assertThatThrownBy(() -> {
            new LottoNumber(99);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 숫자 범위를 초과하는 객체 생성시 에러 발생")
    @Test
    void getNumberWithErrorMinus() {
        assertThatThrownBy(() -> {
            new LottoNumber(-20);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("두개의 lottoNumber 클래스의 값이 같을때")
    @Test
    void compareToEqual() {
        boolean equals = lottoNumber.equals(new LottoNumber(2));
        assertThat(equals).isEqualTo(true);
    }

    @DisplayName("두개의 lottoNumber 클래스의 값이 다를때")
    @Test
    void compareToNotEqual() {
        boolean equals = lottoNumber.equals(new LottoNumber(3));
        assertThat(equals).isEqualTo(false);
    }

}