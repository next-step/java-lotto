package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoResultTest {
    @Test
    void 당첨정보() {
        assertThat(LottoResult.FIRST.getMoney()).isEqualTo(2000000000);
        assertThat(LottoResult.FIRST.getMatchCount()).isEqualTo(6);
    }

    @Test
    void 생성() {
        assertThat(LottoResult.from(3)).isEqualTo(LottoResult.FORTH);
    }
}
