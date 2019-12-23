package lotto.domain;

import lotto.exception.LottoServiceException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 사이즈가_6이_아니면_오류를_내보낸다() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(6));
        number.add(LottoNumber.of(7));
        number.add(LottoNumber.of(5));
        assertThatThrownBy(() -> Lotto.of(number)).isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_NUMBER_SIZE.getDescription());
    }

    @Test
    void 로또넘버를_스트링으로_잘_조회하는지_확인() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(5));
        number.add(LottoNumber.of(6));
        Lotto lotto = Lotto.of(number);
        System.out.println(lotto.getNumbersAsString());
        assertThat(lotto.getNumbersAsString()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void 매치카운트가_맞는지_확인한다() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(5));
        number.add(LottoNumber.of(6));
        Lotto lotto = Lotto.of(number);

        Set<LottoNumber> number2 = new HashSet<>();
        number2.add(LottoNumber.of(1));
        number2.add(LottoNumber.of(2));
        number2.add(LottoNumber.of(3));
        number2.add(LottoNumber.of(4));
        number2.add(LottoNumber.of(5));
        number2.add(LottoNumber.of(7));
        Lotto lotto2 = Lotto.of(number2);

        assertThat(lotto.matchCount(lotto2)).isEqualTo(5);
    }

    @Test
    void 보너스_볼_입력_맞는지_확인() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(5));
        number.add(LottoNumber.of(6));
        Lotto lotto = Lotto.of(number);

        assertThat(lotto.hasBonusBall(LottoNumber.of(20))).isFalse();
        assertThat(lotto.hasBonusBall(LottoNumber.of(1))).isTrue();
    }
}
