package lotto.step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @RepeatedTest(3)
    @DisplayName("로또 번호를 만들면, 1이상 45이하의 중복되지 않은 6개의 수를 반환한다.")
    void testLottoHasUniqueSixNumbersWhichAre1to45() {
        //given
        //when
        Set<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        //then
        assertThat(lottoNumbers).hasSize(6)
                .allMatch(number -> 1 <= number && number <= 45);
    }
}
