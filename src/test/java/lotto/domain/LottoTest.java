package lotto.domain;

import lotto.exception.LottoDuplicateNumberException;
import lotto.exception.NumberOfLottoNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTest {

    @Test
    @DisplayName("중복 번호가 있는지 확인한다")
    void 중복_번호_확인() {
        Assertions.assertThatThrownBy(
                () ->new Lotto(IntStream.of(1,2,3,4,5,5)
                        .mapToObj(LottoNumber::createLottoNumber)
                        .collect(Collectors.toList()))
        ).isInstanceOf(LottoDuplicateNumberException.class)
                .hasMessage("중복 요소: 5가 하나 이상 존재");

    }

    @Test
    @DisplayName("숫자가 6개인지 확인한다")
    void 로또_숫자_6개(){
        Assertions.assertThatThrownBy(
                        () ->new Lotto(IntStream.of(1,2,3,4,5)
                                .mapToObj(LottoNumber::createLottoNumber)
                                .collect(Collectors.toList()))
                ).isInstanceOf(NumberOfLottoNumberException.class)
                .hasMessage("현재 로또 번호 개수 : 5 하나의 로또의 로또 번호 개수는 6개여야 함");
    }

}
