package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManualGeneratorTest {

    @DisplayName("수동으로 주어지는 로또 넘버를 Generator가 그대로 반환하는지 테스트")
    @Test
    void testManualNumbersValid() {
        assertThat(new LottoManualGenerator(1,2,3,4,5,6).generateNumbers())
            .isEqualTo(Stream.of(1,2,3,4,5,6).map(Number::new).collect(Collectors.toList()));
    }
}
