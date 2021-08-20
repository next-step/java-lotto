package lotto.enumeration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.WrongMatchedCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRewardTest {

    @ParameterizedTest
    @MethodSource("provideRewardInfo")
    @DisplayName("일치한 번호수와 보너스번호 일치여부에 맞는 당첨정보를 반환한다.")
    void return_proper_reward(int matchedCount, boolean matchBonusNumber,
        LottoReward expectedReward) {

        LottoReward reward = LottoReward.of(matchedCount, matchBonusNumber);
        assertThat(reward).isEqualTo(expectedReward);

    }


    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9})
    @DisplayName("6이상의 당첨일치 개수가 입력될경우, 예외를 던진다.")
    void check_wrong_matched_number(int matchedCount) {
        boolean matchBonusNumber = false;

        assertThatThrownBy(() -> LottoReward.of(matchedCount, matchBonusNumber))
            .isInstanceOf(WrongMatchedCountException.class);

    }

    private static Stream<Arguments> provideRewardInfo() {

        return Stream.of(
            Arguments.of(1, false, LottoReward.NO_MATCHED),
            Arguments.of(1, true, LottoReward.NO_MATCHED),
            Arguments.of(2, false, LottoReward.NO_MATCHED),
            Arguments.of(2, true, LottoReward.NO_MATCHED),
            Arguments.of(3, false, LottoReward.THREE_NUMBERS_MATCHED),
            Arguments.of(3, true, LottoReward.THREE_NUMBERS_MATCHED),
            Arguments.of(4, false, LottoReward.FOUR_NUMBERS_MATCHED),
            Arguments.of(4, true, LottoReward.FOUR_NUMBERS_MATCHED),
            Arguments.of(5, false, LottoReward.FIVE_NUMBERS_MATCHED),
            Arguments.of(5, true, LottoReward.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED),
            Arguments.of(6, false, LottoReward.SIX_NUMBERS_MATCHED),
            Arguments.of(6, true, LottoReward.SIX_NUMBERS_MATCHED)
        );
    }
}