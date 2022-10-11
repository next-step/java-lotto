package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @DisplayName("주어진 개수만큼 로또 번호가 생성된다.")
    @Test
    void generate_size() {
        List<Lotto> lottos = LottoGenerator.generate(3);

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("1보다 작은 size가 주어지면 예외가 발생한다.")
    @Test
    void generate_min_size() {
        assertThatThrownBy(() -> LottoGenerator.generate(0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 size가 필요합니다.");
    }
}
