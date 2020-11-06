package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 숫자 생성기 테스트")
public class LottoNumberGeneratorTest {
    @DisplayName("생성된 로또 숫자 개수")
    @Test
    public void getLottoNumberCount() {
        List<Integer> numbers = LottoNumberGenerator.getNumbers();

        int count = numbers.size();

        assertThat(count).isEqualTo(Lotto.NUMBER_COUNT);
    }
}