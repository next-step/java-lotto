package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRankTest {

    @ParameterizedTest
    @DisplayName("맞힌 숫자와 보너스 숫자 매칭 여부에 따른 랭킹 확인")
    @CsvSource(value = {
            "6,false,1",
            "5,true,2",
            "5,false,3",
            "4,true,4"})
    public void 랭킹_조건_확인(int matchCount, boolean matchBonus, int expectedRank) {
        Assertions.assertThat(LottoRank.valueOf(matchCount, matchBonus).ordinal()+1)
                .isEqualTo(expectedRank);
    }

    @Test
    @DisplayName("티켓의 순위에 따른 전체 상금 계산")
    public void 전체_상금_계산 () {
        List<LottoRank> matchResult = Arrays.asList(
                LottoRank.FIRST,
                LottoRank.LAST,
                LottoRank.LAST,
                LottoRank.FIFTH
        );
        Assertions.assertThat(LottoRank.calculateTotalPrize(matchResult))
                .isEqualTo(2_000_005_000);
    }

    @Test
    public void 랭킹_숫자로_LottoRank_객체_가져오기() {
        Assertions.assertThat(LottoRank.getByRank(1))
                .isEqualTo(LottoRank.FIRST);
    }
}
