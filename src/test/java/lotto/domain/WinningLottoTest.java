package lotto.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @RepeatedTest(20)
    void 인풋이_제대로_되는지_확인한다() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(5));
        number.add(LottoNumber.of(6));

        assertThat(WinningLotto.of("1,2,3,4,5,6", 7).getBonusBall()).isEqualTo(LottoNumber.of(7));
        assertThat(WinningLotto.of("1,2,3,4,5,6", 7).getNumbers()
                .stream()
                .anyMatch(e -> e.equals(number.stream().findAny().get())))
                .isTrue();

    }
}
