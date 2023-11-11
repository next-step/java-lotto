package lotto.step2.domain;

import lotto.step2.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @RepeatedTest(3)
    @DisplayName("Lotto 객체를 생성하면, Lotto는 1~45까지의 수를 중복되지 않게 6개 가지고 있다.")
    void testLottoHasUniqueSixNumbers() {
        //given
        Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());

        //when
        Set<Integer> numbers = lotto.nums();

        //then
        assertThat(numbers)
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }
}
