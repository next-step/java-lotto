package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.WinningInformation.FIVE_AND_BONUS_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

class WinningInformationTest {

    @DisplayName("일치수의 경계값은 0 ~ 6개이다.")
    @ParameterizedTest
    @EnumSource(WinningInformation.class)
    void count_matches(WinningInformation information) {
        assertThat(information.getMatchesCount() >= 0 && information.getMatchesCount() <= 7).isTrue();
    }

    @DisplayName("당첨금액의 경계값은 0 ~ 2,000,000,000원 이다.")
    @ParameterizedTest
    @EnumSource(WinningInformation.class)
    void amount(WinningInformation information) {
        assertThat(information.amountCompareTo(new Money(0))).isGreaterThanOrEqualTo(0);
        assertThat(information.amountCompareTo(new Money(2_000_000_000))).isLessThanOrEqualTo(0);
    }

    @DisplayName("파라미터에 5와 true가 입력되면 FIVE_AND_BONUS_MATCHES를 반환한다.")
    @Test
    void of_matchesCount_isBonusMatch() {
        assertThat(WinningInformation.of(5, true)).isEqualTo(FIVE_AND_BONUS_MATCHES);
    }

    @DisplayName("상금의 총 합을 구한다.")
    @Test
    void sum_amounts() {
        List<WinningInformation> winningInformations = Arrays.stream(WinningInformation.values())
                .collect(Collectors.toList());

        Money actual = WinningInformation.sumAmounts(winningInformations);

        assertThat(actual).isEqualTo(new Money(2_031_555_000));
    }
}
