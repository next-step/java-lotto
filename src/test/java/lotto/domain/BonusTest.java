package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BonusTest {

    @ParameterizedTest(name = "당첨번호와_일치하는_보너스_숫자가_있는지_확인_가능하다")
    @CsvSource({"5, true", "7, false"})
    void 당첨번호와_일치하는_보너스_숫자가_있는지_확인_가능하다(int input, boolean expected) {
        Bonus bonus = new Bonus(input);

        boolean actual = bonus.compareWith(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(actual).isEqualTo(expected);
    }
}
