package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.dto.WinLotteryResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static lotto.domain.lotto.LottoTicketMockFactory.createLottoHasNumberOneToSix;
import static lotto.domain.lotto.LottoTicketMockFactory.createLottoTicket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankCalculatorTest {

    @DisplayName("calculateWinLotteryResult")
    @Nested
    class CalculateWinLotteryResult {
        @DisplayName("로또 번호를 모두 맞춘 경우 1등 결과를 반환")
        @Test
        void return_first_result_when_hit_all_lotto_number() {
            // given
            final LottoRankCalculator calculator = new LottoRankCalculator();
            final LottoTickets lottoTickets = LottoTickets.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket winningLottery = createLottoHasNumberOneToSix();
            final LottoNumber lottoNumber = LottoNumber.MAX;

            // when
            final WinLotteryResult result = calculator.calculateWinLotteryResult(lottoTickets, winningLottery, lottoNumber);

            // then
            assertAll(
                    () -> assertThat(result.getFirstRank().getCount()).isOne(),
                    () -> assertThat(result.getSecondRank().getCount()).isZero(),
                    () -> assertThat(result.getThirdRank().getCount()).isZero(),
                    () -> assertThat(result.getFourthRank().getCount()).isZero(),
                    () -> assertThat(result.getFifthRank().getCount()).isZero(),
                    () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.FIRST.getWinningMoney())
            );
        }

        @DisplayName("로또 번호를 5개 맞추고 보너스까지 맞춘 경우 2등 결과를 반환")
        @Test
        void return_second_result_when_hit_five_lotto_number_and_bonus_number() {
            // given
            final LottoRankCalculator calculator = new LottoRankCalculator();
            final LottoTickets lottoTickets = LottoTickets.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket winningLottery = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
            final LottoNumber bonusNumber = LottoNumber.of(6);

            // when
            final WinLotteryResult result = calculator.calculateWinLotteryResult(lottoTickets, winningLottery, bonusNumber);

            // then
            assertAll(
                    () -> assertThat(result.getFirstRank().getCount()).isZero(),
                    () -> assertThat(result.getSecondRank().getCount()).isOne(),
                    () -> assertThat(result.getThirdRank().getCount()).isZero(),
                    () -> assertThat(result.getFourthRank().getCount()).isZero(),
                    () -> assertThat(result.getFifthRank().getCount()).isZero(),
                    () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.SECOND.getWinningMoney())
            );
        }

        @DisplayName("로또 번호를 5개 맞춘 경우 3등 결과를 반환")
        @Test
        void return_third_result_when_hit_five_lotto_number() {
            // given
            final LottoRankCalculator calculator = new LottoRankCalculator();
            final LottoTickets lottoTickets = LottoTickets.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket winningLottery = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
            final LottoNumber lottoNumber = LottoNumber.MAX;

            // when
            final WinLotteryResult result = calculator.calculateWinLotteryResult(lottoTickets, winningLottery, lottoNumber);

            // then
            assertAll(
                    () -> assertThat(result.getFirstRank().getCount()).isZero(),
                    () -> assertThat(result.getSecondRank().getCount()).isZero(),
                    () -> assertThat(result.getThirdRank().getCount()).isOne(),
                    () -> assertThat(result.getFourthRank().getCount()).isZero(),
                    () -> assertThat(result.getFifthRank().getCount()).isZero(),
                    () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.THIRD.getWinningMoney())
            );
        }

        @DisplayName("로또 번호를 3개 맞춘 경우 5등 결과를 반환")
        @Test
        void return_fifth_result_when_hit_three_lotto_number() {
            // given
            final LottoRankCalculator calculator = new LottoRankCalculator();
            final LottoTickets lottoTickets = LottoTickets.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket winningLottery = createLottoTicket(Arrays.asList(1, 2, 3, 8, 9, 10));
            final LottoNumber lottoNumber = LottoNumber.MAX;

            // when
            final WinLotteryResult result = calculator.calculateWinLotteryResult(lottoTickets, winningLottery, lottoNumber);

            // then
            assertAll(
                    () -> assertThat(result.getFirstRank().getCount()).isZero(),
                    () -> assertThat(result.getSecondRank().getCount()).isZero(),
                    () -> assertThat(result.getThirdRank().getCount()).isZero(),
                    () -> assertThat(result.getFourthRank().getCount()).isZero(),
                    () -> assertThat(result.getFifthRank().getCount()).isOne(),
                    () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.FIFTH.getWinningMoney())
            );
        }
    }


}