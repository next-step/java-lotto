package lotto.domain;

import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class NumbersGeneratorTest {
    @Test
    void 생성_테스트() {
        Set<Integer> a = LottoNumberGenerator.generate();
        assertThat(LottoNumberGenerator.generate().size()).isEqualTo(6);
    }
}
