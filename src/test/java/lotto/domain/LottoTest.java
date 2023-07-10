package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 숫자로 이루어진다.")
    void createSixNumbersTest() {
        //given
        Lotto lotto = Lotto.createLotto();

        //when, then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또는 서로 다른 숫자들로 이루어진다.")
    void distinctNumbersTest() {
        //given
        Lotto lotto = Lotto.createLotto();

        //when
        List<LottoNumber> numbers = lotto.getLottoNumbers();

        //then
        assertThat(numbers.stream().distinct().count()).isEqualTo(numbers.size());
    }
}
