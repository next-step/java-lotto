package lotto.domain;

import lotto.fixture.LottoNumberFixture;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WinningLottoNumbersTest {

    @Test
    void 당첨번호_보너스볼_중복() {
        // given
        List<LottoNumber> numbers = LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = LottoNumber.from(6);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> WinningLottoNumbers.of(numbers, bonus);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("보너스볼의 번호는 당첨번호와 중복된 번호일 수 없습니다.");
    }

}
