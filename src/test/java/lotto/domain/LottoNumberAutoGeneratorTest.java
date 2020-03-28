package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberAutoGeneratorTest {

    @DisplayName("로또 번호를 자동으로 생성할 수 있다")
    @Test
    public void generateLottoNumbersTest() {
        List<Integer> integers = new LottoNumberAutoGenerator().get();

        assertThat(integers)
                .filteredOn(lottoNumber -> 1 <= lottoNumber && lottoNumber <= 45)
                .size().isEqualTo(6);
    }

}
