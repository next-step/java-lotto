package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step2.dto.LottoStatisticsResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.LottoBuyer.MONEY_MUST_NOT_BE_NULL;

public class LottoBuyerTest {
    @DisplayName("구매자가 로또를 구매")
    @Test
    void buy_lotto() {
        // given
        final Money money = Lotto.getPrice().multiply(2);
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
        void fail_when_receive_null() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                LottoBuyer.of(null);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_NOT_BE_NULL);
        }

        @DisplayName("성공")
        @Test
        void success() {
            // given
            final Money money = Lotto.getPrice();

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
        final Money money = Lotto.getPrice();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        
        // when
        final Lottos lottos = lottoBuyer.getLottos();
        
        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isZero();
    }
    
    @DisplayName("로또 통계 정보를 가져온다")
    @Test
    void get_win_lottery() {
        // given
        final Money money = Lotto.getPrice().multiply(10);
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        final List<LottoNumber> lottoNumberOneToSix = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        final Lotto winningLottery = Lotto.of(lottoNumberOneToSix);

        // when
        final LottoStatisticsResult lottoStatisticsResult = lottoBuyer.getWinLotteryStatistics(winningLottery);
        
        // then
        assertThat(lottoStatisticsResult).isNotNull();
    }
}
