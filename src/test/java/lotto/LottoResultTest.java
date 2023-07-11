package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {

    @Test
    void 로또_당첨결과_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoResult(List.of()));
    }

    @Test
    void 로또_당첨결과가_올바르게_저장_성공() {
        // given
        LottoResult lottoResult = new LottoResult(List.of(Rank.SECOND, Rank.FOURTH, Rank.SECOND));

        // when & then
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIRST)).isZero();
    }
}
