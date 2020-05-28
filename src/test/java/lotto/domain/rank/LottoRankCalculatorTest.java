package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankCalculatorTest {

    @Test
    void lottoRankCalculatorTest_1등_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.FIRST.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.FIRST.getWinningMoney());
    }

    @Test
    void lottoRankCalculatorTest_2등_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 7");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.SECOND.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.SECOND.getWinningMoney());
    }

    @Test
    void lottoRankCalculatorTest_3등_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 8");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.THIRD.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.THIRD.getWinningMoney());
    }

    @Test
    void lottoRankCalculatorTest_4등_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 8, 9, 10");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.FOURTH.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.FOURTH.getWinningMoney());
    }

    @Test
    void lottoRankCalculatorTest_5등_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.FIFTH.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.FIFTH.getWinningMoney());
    }

    @Test
    void lottoRankCalculatorTest_MISS_계산() {
        LottoTicket winLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber lottoBonusNumber = LottoNumber.create(7);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, lottoBonusNumber);

        LottoTicket lottoTicket = new LottoTicket("8, 9, 10, 11, 12, 13");
        LottoRank rank = lottoRankCalculator.calculate(lottoTicket);

        assertThat(rank.getCountOfMatch()).isEqualTo(LottoRank.MISS.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(LottoRank.MISS.getWinningMoney());
    }
}
