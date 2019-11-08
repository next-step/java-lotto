package lottery.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lottery.domain.Prize;
import lottery.dto.LottoResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoResultTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 매치된_숫자_개수_체크테스트(int matchedCount) {
        LottoResult result = new LottoResult(matchedCount, false);
        assertThat(result.isPrize(Prize.getPrize(matchedCount, false))).isTrue();
    }

    @Test
    void 무효한_매치_숫자_입력테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoResult(7, false);
        });
    }

    @Test
    void 보너스_맞추면_2등_체크테스트() {
        LottoResult secondResult = new LottoResult(5, true);
        assertThat(secondResult.isPrize(Prize.SECOND)).isTrue();

        LottoResult thirdResult = new LottoResult(5, false);
        assertThat(thirdResult.isPrize(Prize.THIRD)).isTrue();
    }
}