package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicketGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lotto.dto.LottoStatisticsResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_MUST_NOT_BE_BLANK;
import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE_NOT_VALID;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static lotto.domain.LottoGame.MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO;
import static lotto.domain.Money.MONEY_MUST_NOT_BE_NEGATIVE;

public class LottoGameTest {
    @DisplayName("구매자가 로또를 구매")
    @Nested
    class BuyLottoTicket {
        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int money = LottoTicket.getPrice().multiply(2).getValue();
            final LottoGame lottoGame = LottoGame.of(money);

            // when
            final LottoTicketGroup lottoTicketGroup = lottoGame.buyLotto(Collections.emptyList());

            // then
            assertThat(lottoTicketGroup.size()).isEqualTo(2);
        }

        @DisplayName("성공")
        @Test
        void buyer_do_not_have_money() {
            // given
            final int money = 0;
            final LottoGame lottoGame = LottoGame.of(money);

            // when
            final Throwable thrown = catchThrowable(() -> {
                lottoGame.buyLotto(Collections.emptyList());
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO);
        }
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
                LottoGame.of(negative);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_NOT_BE_NEGATIVE);
        }

        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int money = LottoTicket.getPrice().getValue();

            // when
            final LottoGame lottoGame = LottoGame.of(money);

            // then
            assertThat(lottoGame).isNotNull();
        }
    }

    @DisplayName("로또 조회 요청시 null을 반환하지 않는다.")
    @Test
    void getLottos_not_return_null() {
        // given
        final int money = LottoTicket.getPrice().getValue();
        final LottoGame lottoGame = LottoGame.of(money);

        // when
        final LottoTicketGroup lottoTicketGroup = lottoGame.getLottoTicketGroup();

        // then
        assertThat(lottoTicketGroup).isNotNull();
        assertThat(lottoTicketGroup.size()).isZero();
    }

    @DisplayName("getWinLotteryStatistics")
    @Nested
    class GetWinLotteryStatistics {
        @DisplayName("로또 통계 정보를 가져온다")
        @Test
        void get_win_lottery() {
            // given
            final int money = LottoTicket.getPrice().multiply(10).getValue();
            final LottoGame lottoGame = LottoGame.of(money);
            final String winningNumberExpression = "1, 2, 3, 4, 5, 6";

            // when
            final LottoStatisticsResult lottoStatisticsResult = lottoGame.getWinLotteryStatistics(winningNumberExpression, LottoNumber.MAX.getValue());

            // then
            assertThat(lottoStatisticsResult).isNotNull();
        }

        @DisplayName("로또 번호로 빈 문자열을 받은 경우")
        @Test
        void lotto_number_is_empty() {
            // given
            final int money = LottoTicket.getPrice().multiply(10).getValue();
            final LottoGame lottoGame = LottoGame.of(money);
            final String winningNumberExpression = " ";

            // when
            final Throwable thrown = catchThrowable(() -> {
                lottoGame.getWinLotteryStatistics(winningNumberExpression, LottoNumber.MIN.getValue());
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_BLANK);
        }

        @DisplayName("로또 번호 개수가 유효 하지 못한 경우")
        @Test
        void not_valid_lotto_number_size() {
            // given
            final int money = LottoTicket.getPrice().multiply(10).getValue();
            final LottoGame lottoGame = LottoGame.of(money);
            final String winningNumberExpression = "1, 2, 3, 4, 5, 6, 7";

            // when
            final Throwable thrown = catchThrowable(() -> {
                lottoGame.getWinLotteryStatistics(winningNumberExpression, LottoNumber.MIN.getValue());
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_SIZE_NOT_VALID);
        }
    }

    @DisplayName("로또를 수동으로도 구매할 수 있다")
    @Test
    void buyLotto() {
        // given
        final int money = LottoTicket.getPrice().multiply(10).getValue();
        final LottoGame lottoGame = LottoGame.of(money);
        final List<String> lottoNumberExpressionList = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");

        // when
        lottoGame.buyLotto(lottoNumberExpressionList);

        // then
        final int numOfLotto = lottoGame.getLottoTicketGroup().size();
        assertThat(numOfLotto).isEqualTo(10);
    }
}
