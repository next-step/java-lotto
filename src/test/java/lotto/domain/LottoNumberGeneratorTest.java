package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("1부터 45까지의 숫자 중 6개를 랜덤으로 생성")
    @Test
    void generateTest() {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        List<Integer> result = lottoNumberGenerator.generate();

        assertThat(result).hasSize(6);
    }
}
