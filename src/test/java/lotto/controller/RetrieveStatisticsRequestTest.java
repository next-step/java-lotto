package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또에 대한 통계 요청에 전달된 파라미터 객체 테스트")
class RetrieveStatisticsRequestTest {

    private static final Lottos PURCHASED_LOTTOS = Lottos.from(2);
    private static final List<Integer> WINNING_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("정상적인 로또 통계 요청")
    @Test
    void createValidCaseTest() {
        // when
        RetrieveStatisticsRequest request = RetrieveStatisticsRequest.of(PURCHASED_LOTTOS, WINNING_LOTTO_NUMBERS);
        // then
        assertAll(
                () -> assertThat(request).isNotNull(),
                () -> assertThat(request.winningLotto()).isEqualTo(new Lotto(new LottoNumbers(WINNING_LOTTO_NUMBERS)))
        );
    }

    @DisplayName("비정상적인 로또 통계 요청 - 구입한 로또가 없는 경우")
    @ParameterizedTest
    @NullSource
    void createInvalidCaseWithoutLottosTest(Lottos lottos) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RetrieveStatisticsRequest.of(lottos, WINNING_LOTTO_NUMBERS)
        );
    }

    @DisplayName("비정상적인 로또 통계 요청 - 당첨 로또 정보가 없는 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void createInvalidCaseWithoutWinningLottoTest(List<Integer> winningLottoNumbers) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RetrieveStatisticsRequest.of(PURCHASED_LOTTOS, winningLottoNumbers)
        );
    }
}
