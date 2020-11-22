package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.domain.lotto.LottoTicketMockFactory;
import lotto.dto.WinLotteryResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static lotto.domain.lotto.LottoTicketMockFactory.createLottoHasNumberOneToSix;
import static lotto.domain.lotto.LottoTicketMockFactory.createLottoTicket;
import static lotto.domain.rank.WinningLotto.WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoTest {
    @DisplayName("생성")
    @Test
    void of() {
        // given
        final LottoTicket lottoTicket = LottoTicketMockFactory.createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(7);

        // when
        final WinningLotto result = WinningLotto.of(lottoTicket, bonusNumber);

        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("당첨 로또 번호와 보너스 번호 중복 시 예외 반환")
    @Test
    void of_throw_exception_when_lotto_no_and_bonus_no_duplicated() {
        // given
        final LottoTicket lottoTicket = LottoTicketMockFactory.createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(6);

        // when
        final Throwable thrown = catchThrowable(() -> {
            WinningLotto.of(lottoTicket, bonusNumber);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED);
    }

    @DisplayName("calculateWinLotteryResult")
    @Nested
    class CalculateWinLotteryResult {
        @DisplayName("로또 번호를 모두 맞춘 경우 1등 결과를 반환")
        @Test
        void return_first_result_when_hit_all_lotto_number() {
            // given
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket lottoTicket = createLottoHasNumberOneToSix();
            final LottoNumber bonusNumber = LottoNumber.of(LottoNumber.MAX_NO);
            ;
            final WinningLotto winningLotto = WinningLotto.of(lottoTicket, bonusNumber);

            // when
            final WinLotteryResult result = winningLotto.calculateWinLotteryResult(lottoTicketGroup);

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
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
            final LottoNumber bonusNumber = LottoNumber.of(6);
            final WinningLotto winningLotto = WinningLotto.of(lottoTicket, bonusNumber);

            // when
            final WinLotteryResult result = winningLotto.calculateWinLotteryResult(lottoTicketGroup);

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
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
            final LottoNumber bonusNumber = LottoNumber.of(LottoNumber.MAX_NO);
            final WinningLotto winningLotto = WinningLotto.of(lottoTicket, bonusNumber);

            // when
            final WinLotteryResult result = winningLotto.calculateWinLotteryResult(lottoTicketGroup);

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
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Collections.singletonList(createLottoHasNumberOneToSix()));
            final LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 8, 9, 10));
            final LottoNumber bonusNumber = LottoNumber.of(LottoNumber.MAX_NO);
            final WinningLotto winningLotto = WinningLotto.of(lottoTicket, bonusNumber);

            // when
            final WinLotteryResult result = winningLotto.calculateWinLotteryResult(lottoTicketGroup);

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