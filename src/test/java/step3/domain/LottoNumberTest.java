package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.OneToSixLottoMakeStrategy;
import step3.exception.LottoMoneyException;
import step3.exception.LottoNumberRangeException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {



    @DisplayName("로또 번호가 잘 생성되는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1,45})
    void createLottoNumber(int lottoNumber) {
        assertThat(new LottoNumber(lottoNumber)).isEqualTo(new LottoNumber(lottoNumber));

    }

    @Test
    @DisplayName("로또 번호가 1미만일 경우 익셉션이 발생합니다.")
    void throwRangeExceptionWith1(){
        assertThatThrownBy(() ->new LottoNumber(0))
                .isInstanceOf(LottoNumberRangeException.class);
    }
    @Test
    @DisplayName("로또 번호가 45 초과일 경우 익셉션이 발생합니다.")
    void throwRangeExceptionWith45(){
        assertThatThrownBy(() ->new LottoNumber(46))
                .isInstanceOf(LottoNumberRangeException.class);
    }

}