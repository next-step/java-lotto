package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllLottoNumbersTest {

    @Test
    void 로또_번호_size_검증() {
        AllLottoNumbers allLottoNumbers = new AllLottoNumbers();

        assertThat(allLottoNumbers.getLottoNumbers()).hasSize(45);
    }
}
