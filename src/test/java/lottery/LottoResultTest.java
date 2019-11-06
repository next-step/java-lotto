package lottery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lottery.domain.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoResultTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 매치된_숫자_개수_체크테스트(int matchedCount) {
        LottoResult result = new LottoResult(matchedCount);
        assertThat(result.isPrize(Prize.getPrize(matchedCount))).isTrue();
    }

    @Test
    void 무효한_매치_숫자_입력테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoResult(7);
        });
    }
}