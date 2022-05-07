package lotto.domain;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class NumbersGeneratorTest {
    @Test
    void 생성_테스트() {
        List<Integer> a = LottoNumberGenerator.generate();
        assertThat(LottoNumberGenerator.generate().size()).isEqualTo(6);
    }
}
