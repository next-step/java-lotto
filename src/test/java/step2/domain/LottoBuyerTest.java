package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step2.dto.LottoStatisticsResult;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.Lotto.LOTTO_NUMBER_MUST_NOT_BE_BLANK;
import static step2.domain.Lotto.LOTTO_NUMBER_SIZE_NOT_VALID;
import static step2.domain.Money.MONEY_MUST_NOT_BE_NEGATIVE;

public class LottoBuyerTest {
    @DisplayName("구매자가 로또를 구매")
    @Test
    void buy_lotto() {
        // given
        final int money = Lotto.getPrice().multiply(2).getValue();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);

        // when
        final Lottos lottos = lottoBuyer.buy();

        // then
        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("생성")
    @Nested
    class Create {
        @DisplayName("실패")
        @Test
        void fail_when_receive_negative() {
            // given
            final int negative = -1;
            
            // when
            final Throwable thrown = catchThrowable(() -> {
                LottoBuyer.of(negative);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_NOT_BE_NEGATIVE);
        }

        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int money = Lotto.getPrice().getValue();

            // when
            final LottoBuyer lottoBuyer = LottoBuyer.of(money);

            // then
            assertThat(lottoBuyer).isNotNull();
        }
    }

    @DisplayName("로또 조회 요청시 null을 반환하지 않는다.")
    @Test
    void getLottos_not_return_null() {
        // given
        final int money = Lotto.getPrice().getValue();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);

        // when
        final Lottos lottos = lottoBuyer.getLottos();

        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isZero();
    }

    @DisplayName("getWinLotteryStatistics")
    @Nested
    class GetWinLotteryStatistics {
        @DisplayName("로또 통계 정보를 가져온다")
        @Test
        void get_win_lottery() {
            // given
            final int money = Lotto.getPrice().multiply(10).getValue();
            final LottoBuyer lottoBuyer = LottoBuyer.of(money);
            final String winningNumberExpression = "1, 2, 3, 4, 5, 6";

            // when
            final LottoStatisticsResult lottoStatisticsResult = lottoBuyer.getWinLotteryStatistics(winningNumberExpression);

            // then
            assertThat(lottoStatisticsResult).isNotNull();
        }

        @DisplayName("로또 번호로 빈 문자열을 받은 경우")
        @Test
        void lotto_number_is_empty() {
            // given
            final int money = Lotto.getPrice().multiply(10).getValue();
            final LottoBuyer lottoBuyer = LottoBuyer.of(money);
            final String winningNumberExpression = " ";

            // when
            final Throwable thrown = catchThrowable(() -> {
                lottoBuyer.getWinLotteryStatistics(winningNumberExpression);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_BLANK);
        }

        @DisplayName("로또 번호 개수가 유효 하지 못한 경우")
        @Test
        void not_valid_lotto_number_size() {
            // given
            final int money = Lotto.getPrice().multiply(10).getValue();
            final LottoBuyer lottoBuyer = LottoBuyer.of(money);
            final String winningNumberExpression = "1, 2, 3, 4, 5, 6, 7";

            // when
            final Throwable thrown = catchThrowable(() -> {
                lottoBuyer.getWinLotteryStatistics(winningNumberExpression);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_SIZE_NOT_VALID);
        }
    }
}
