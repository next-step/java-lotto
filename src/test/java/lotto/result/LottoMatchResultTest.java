package lotto.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoMatchResultTest {

    @Test
    void 생성자_정상입력_생성성공() {
        assertThatCode(() -> new LottoMatchResult(Rank.FIRST, Rank.FOURTH)).doesNotThrowAnyException();
    }

    @Test
    void totalPrize_총상금계산() {
        LottoMatchResult result = new LottoMatchResult(Rank.FIRST, Rank.FIFTH);
        result.updateRank(Rank.THIRD);
        System.out.println(result);
        assertThat(result.totalPrize())
                .isEqualTo(2_001_505_000);
    }
}