package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.generator.CompositeLottosGenerator;
import lotto.domain.generator.LottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompositeLottosGeneratorTest {
    @Test
    @DisplayName("Composite는 여러 Generator의 결과를 합쳐 하나의 Lottos로 만든다")
    void compositeMergesChildren() {
        LottosGenerator a = () -> new Lottos(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        LottosGenerator b = () -> new Lottos(List.of(new Lotto(List.of(7,8,9,10,11,12))));

        Lottos merged = CompositeLottosGenerator.of(a, b).generate();

        assertThat(merged.size()).isEqualTo(2);
    }
}
