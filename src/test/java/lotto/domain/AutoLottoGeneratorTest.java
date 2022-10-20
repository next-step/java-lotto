package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @DisplayName("주어진 개수만큼 로또들이 생성된다.")
    @Test
    void generate_size() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        List<Lotto> lottos = autoLottoGenerator.generate(new PlayLottoCount(3));
        int actual = lottos.size();

        assertThat(actual).isEqualTo(3);
    }
}
