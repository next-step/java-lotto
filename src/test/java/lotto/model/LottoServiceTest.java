package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void draw() {
        LottoService lottoService = new LottoService(5000, new Always_Return_1_2_3_4_5_6());
        lottoService.drawLotto("1, 2, 3, 7, 8, 9");
        assertThat(lottoService.returnRate()).isEqualTo(5.0);
    }

    static class Always_Return_1_2_3_4_5_6 extends RandomGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }
}