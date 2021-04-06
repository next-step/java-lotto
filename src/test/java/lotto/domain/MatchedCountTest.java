package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchedCountTest {

    @Test
    @DisplayName("매칭된 수 객체 생성")
    public void create() throws Exception {
        //given
        LottoNumbers winningNumbers = LottoNumbers.from(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.from(1, 2, 3, 4, 5, 6);

        //when
        MatchedCount matchedCount = new MatchedCount(winningNumbers.lottoNumbers(), lottoNumbers.lottoNumbers());

        //then
        assertThat(matchedCount).isEqualTo(new MatchedCount(6));
        assertThat(new MatchedCount()).isEqualTo(new MatchedCount(0));
        assertThat(new MatchedCount(3)).isEqualTo(new MatchedCount(3));
    }

    @Test
    @DisplayName("매칭된 개수가 0~ 6 범위가 아닐 경우 예외")
    public void validateBound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new MatchedCount(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new MatchedCount(7));
    }

    @Test
    @DisplayName("매칭된 개수가 크거나 같은 경우")
    public void isGreaterOrEqualThan() throws Exception {
        assertThat(WinningRank.FIRST_PLACE.matchedCount().isGreaterOrEqualThan(5)).isTrue();
        assertThat(WinningRank.SECOND_PLACE.matchedCount().isGreaterOrEqualThan(6)).isFalse();
    }

    @Test
    @DisplayName("자신의 매치 카운트 값 크기가 더 큰 경우")
    public void isGreaterThan() throws Exception {
        assertThat(new MatchedCount(3).isGreaterThan(new MatchedCount(2))).isTrue();
        assertThat(new MatchedCount(3).isGreaterThan(new MatchedCount(3))).isFalse();
    }
}
