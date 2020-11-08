package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 숫자 생성기 테스트")
public class LottoGeneratorTest {
    @DisplayName("생성된 로또 숫자 개수")
    @Test
    public void getLottoNumberCount() {
        Lotto lotto = LottoGenerator.getRandomLotto();

        int count = lotto.getNumbers().size();

        assertThat(count).isEqualTo(Lotto.NUMBER_COUNT);
    }
}