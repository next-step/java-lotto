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
        assertThat(LottoResult.FIRST.getResultMatcher().test(6, true)).isTrue();
        assertThat(LottoResult.FIRST.getResultMatcher().test(6, false)).isTrue();

        assertThat(LottoResult.SECOND.getResultMatcher().test(5, true)).isTrue();
        assertThat(LottoResult.SECOND.getResultMatcher().test(5, false)).isFalse();

        assertThat(LottoResult.THIRD.getResultMatcher().test(5, true)).isFalse();
        assertThat(LottoResult.THIRD.getResultMatcher().test(5, false)).isTrue();

        assertThat(LottoResult.FORTH.getResultMatcher().test(4, true)).isTrue();
        assertThat(LottoResult.FORTH.getResultMatcher().test(4, false)).isTrue();

        assertThat(LottoResult.FIFTH.getResultMatcher().test(3, true)).isTrue();
        assertThat(LottoResult.FIFTH.getResultMatcher().test(3, false)).isTrue();
    }

    @Test
    void 생성() {
        assertThat(LottoResult.from(3, false)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.from(5, true)).isEqualTo(LottoResult.SECOND);
    }
}

