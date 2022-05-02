package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumbersGeneratorTest {

    @Nested
    class generate_메서드는 {

        @Test
        void 길이_6만큼의_로또번호를_리턴한다() {
            List<LottoNumber> actual = RandomLottoNumbersGenerator.generate();

            assertThat(actual).hasSize(6);
        }
    }
}
