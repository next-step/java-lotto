package lotto;

import lotto.model.LottoGenerator;
import lotto.model.LottoStrategy;
import lotto.model.RandomLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("랜덤 로또 번호의 범위와 사이즈 확인 테스트")
    void generateLottoNumber_invalidRangeAndSize() {
        List<Integer> result = new LottoGenerator().generateLottoNumbers(new RandomLottoStrategy());

        for (int i : result) {
            assertThat(i).isBetween(1, 45);
        }

        assertThat(result.size()).isEqualTo(6);
        }
}
