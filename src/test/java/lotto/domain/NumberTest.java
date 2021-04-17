package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {


    @Test
    @DisplayName("로또 번호에 맞는지 검사-안맞을 경우")
    void checkNumberFailTest(){
        assertThatThrownBy(()->{
            Number number = new Number(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 번호에 맞는지 검사-맞을 경우")
    void checkNumberSuccessTest(){
        Number number = new Number(45);
        assertThat(number.number()).isEqualTo(45);
    }



}
