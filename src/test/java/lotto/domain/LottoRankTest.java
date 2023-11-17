package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideMatchCountAndIsBonusAndLottoRank")
    @DisplayName("성공 - 당첨 개수에 보너스 볼에 일치하는 로또 등수를 반환한다.")
    void provideNotContainMatchCountFive(int matchCount, boolean isBonus, LottoRank lottoRank){
        assertThat(LottoRank.of(matchCount, isBonus)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> provideMatchCountAndIsBonusAndLottoRank() {
        return Stream.of(
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(6, false, LottoRank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotContainMatchCountFive")
    @DisplayName("성공 - 숫자 당첨이 5개가 아닐 경우 보너스 볼은 당첨 결과에 영향을 끼치지 않는다.")
    void success_not_contain_match_count_five(int matchCount, boolean isBonus, LottoRank lottoRank){
        assertThat(LottoRank.of(matchCount, isBonus)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> provideNotContainMatchCountFive() {
        return Stream.of(
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(6, true, LottoRank.FIRST)
        );
    }


    @ParameterizedTest
    @CsvSource(value = {"3:5_000:false","4:50_000:false","5:1_500_000:false","5:30_000_000:true","6:2_000_000_000:false"}, delimiter = ':')
    @DisplayName("성공 - 당첨 개수와 보너스 볼에 일치하는 당첨 금액을 반환한다.")
    void success_count_match_prize_amount(int matchCount, int prizeAmount, boolean isBonus){
        assertThat(LottoRank.prizeAmount(matchCount, isBonus)).isEqualTo(prizeAmount);
    }

}
