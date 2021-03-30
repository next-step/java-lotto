package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    @DisplayName("숫자 matchCount 별 LottoRank Enum 조회")
    void lottoRank_inquiryRank(int matchCount, long winAmount) {
        // given
        LottoRank lottoRank = LottoRank.inquiryRank(matchCount, false);

        // when then
        assertThat(matchCount).isEqualTo(lottoRank.getMatchCount());
        assertThat(winAmount).isEqualTo(lottoRank.getWinAmount());
    }

    @Test
    @DisplayName("로또 등수 매치카운트에 해당하지 않는 등수정보는 조회불가")
    void lottoRank_inquiryRank_IllegalParam() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.inquiryRank(9, true));
    }

    @Test
    @DisplayName("보너스 등수 조회")
    void lottoRank_bonusRank() {
        // given
        LottoRank lottoRank = LottoRank.inquiryRank(5, true);

        // when then
        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(lottoRank.getMatchCount());
        assertThat(LottoRank.SECOND.getWinAmount()).isEqualTo(lottoRank.getWinAmount());
        assertThat(LottoRank.SECOND.isMatchBonusTarget()).isEqualTo(lottoRank.isMatchBonusTarget());
    }
}