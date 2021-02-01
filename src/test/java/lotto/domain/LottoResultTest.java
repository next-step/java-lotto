package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("1등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getFirstRankTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoTicket lottoTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoResult lottoResult = new LottoResult(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoResult.getRank();

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getSecondRankTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoResult lottoResult = new LottoResult(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoResult.getRank();

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getThirdRankTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoTicket lottoTicket = new LottoTicket(createPickedThirdNumbers());
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoResult lottoResult = new LottoResult(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoResult.getRank();

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    private List<LottoNumber> createPickedWinningNumbers() {
        return Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
    }

    private List<LottoNumber> createPickedSecondNumbers() {
        return Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(45)
        );
    }

    private List<LottoNumber> createPickedThirdNumbers() {
        return Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(44)
        );
    }
}