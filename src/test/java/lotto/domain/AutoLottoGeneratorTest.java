package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @DisplayName("주어진 개수만큼 로또 번호가 생성된다.")
    @Test
    void generate_size() {
        int actual = AutoLottoGenerator
                .generate(new PlayLottoCount(3))
                .size();

        assertThat(actual).isEqualTo(3);
    }
}
