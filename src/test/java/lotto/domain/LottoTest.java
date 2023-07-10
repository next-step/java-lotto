package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void createLottoTest() {
        Assertions.assertDoesNotThrow(() -> new Lotto(List.of(1,2,3,4,5,6)));
    }

    @Test
    void createSixNumbersTest() {
        //given
        Lotto lotto = Lotto.createLotto();

        //when, then
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void distinctNumbersTest() {
        //given
        Lotto lotto = Lotto.createLotto();

        //when
        List<Integer> numbers = lotto.getNumbers();

        //then
        assertThat(numbers.stream().distinct().count()).isEqualTo(numbers.size());
    }
}
