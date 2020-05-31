package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("로또 매칭 결과 개수를 통해 LottoRank를 가져온다.")
    void 로또_매칭_랭크_테스트() {
        long count = 6;
        LottoRank lottoRank = LottoRank.valueOf(count, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("보너스 매칭 여부를 통해 2등 rank를 가져온다.")
    void 로또_2등_조회_테스트() {
        long count = 5;
        LottoRank lottoRank = LottoRank.valueOf(count, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("BOOM 값을 제외한 enum 값을 가져와서 검증한다.")
    void 로또_BOOM_제외_테스트() {
        List<LottoRank> lottoRanks = LottoRank.valuesWithOutBoom();
        assertThat(lottoRanks.contains(LottoRank.BOOM)).isFalse();
    }

    @MethodSource("generate_lotto_ranks")
    @ParameterizedTest
    @DisplayName("로또 랭크 리스트를 맵 형태로 변환한다.")
    void 로또_맵_convert_테스트(List<LottoRank> lottoRanks, int count) {
        Map<LottoRank, Long> convertedMap = LottoRank.convertLottoRankWithCount(lottoRanks);
        assertThat(convertedMap.get(LottoRank.FIRST)).isEqualTo(count);
    }

    private static Stream<Arguments> generate_lotto_ranks() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        LottoRank.FIRST,
                        LottoRank.FIRST,
                        LottoRank.FIRST,
                        LottoRank.FIRST,
                        LottoRank.FIRST
                ), 5)
        );
    }
}
