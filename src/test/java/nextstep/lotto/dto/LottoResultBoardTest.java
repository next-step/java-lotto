package nextstep.lotto.dto;

import nextstep.lotto.utils.LottoNumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoResultBoardTest {

    LottoTickets lottoTickets;
    LottoWinnerNumbers winnerNumbers;

    private final int LOTTO_VALUE = 1000;

    @BeforeEach
    void setLottoTicket() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<String> lottoTicket1 = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> lottoTicket2 = Arrays.asList("7", "8", "9", "10", "11", "12");
        List<String> lottoTicket3 = Arrays.asList("13", "14", "15", "16", "17", "18");

        List<String> lottoTicket = Arrays.asList("1", "2", "3", "4", "5", "40");

        tickets.add(LottoTicket.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket1)));
        tickets.add(LottoTicket.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket2)));
        tickets.add(LottoTicket.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket3)));


        lottoTickets = LottoTickets.create(tickets);

        winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(7));
    }

    @Test
    void lottoBoard() {
        List<String> lottoTicket = Arrays.asList("1", "2", "3", "4", "5", "6");
        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(7));
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));

        Map<LottoRank, Long> lottoResult = lottoResultBoard.getLottoResult();

        assertThat(lottoResult.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"FIFTH"})
    @DisplayName("5천원구입으로 5등수익률")
    void lottoBenefit_5등_Test(LottoRank rank) {
        List<String> lottoTicket = Arrays.asList("1", "2", "3", "43", "44", "45");
        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(7));
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));
        int buyAmount = lottoTickets.getAll().size();
        float expectedRate = (float) rank.getReward() / (buyAmount * LOTTO_VALUE);
        assertThat(lottoResultBoard.getBenefitRate()).isEqualTo(expectedRate);
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"FOURTH"})
    @DisplayName("5천원구입으로 4등수익률")
    void lottoBenefit_4등_Test(LottoRank rank) {
        List<String> lottoTicket = Arrays.asList("1", "2", "3", "4", "44", "45");
        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(7));
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));

        int buyAmount = lottoTickets.getAll().size();
        float expectedRate = (float) rank.getReward() / (buyAmount * LOTTO_VALUE);
        assertThat(lottoResultBoard.getBenefitRate()).isEqualTo(expectedRate);
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"THIRD"})
    @DisplayName("5천원구입으로 3등수익률")
    void lottoBenefit_3등_Test(LottoRank rank) {
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));

        int buyAmount = lottoTickets.getAll().size();
        float expectedRate = (float) rank.getReward() / (buyAmount * LOTTO_VALUE);
        assertThat(lottoResultBoard.getBenefitRate()).isEqualTo(expectedRate);
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"SECOND"})
    @DisplayName("5천원구입으로 2등수익률")
    void lottoBenefit_2등_Test(LottoRank rank) {
        List<String> lottoTicket = Arrays.asList("1", "2", "3", "4", "5", "45");

        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(6));
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));

        int buyAmount = lottoTickets.getAll().size();
        float expectedRate = (float) rank.getReward() / (buyAmount * LOTTO_VALUE);
        assertThat(lottoResultBoard.getBenefitRate()).isEqualTo(expectedRate);
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"FIRST"})
    @DisplayName("5천원구입으로 1등수익률")
    void lottoBenefit_1등_Test(LottoRank rank) {
        List<String> lottoTicket = Arrays.asList("1", "2", "3", "4", "5", "6");
        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(LottoNumberUtil.transStringNumberToLottoNumber(lottoTicket), LottoNumber.create(7));
        LottoResultBoard lottoResultBoard = LottoResultBoard.create(lottoTickets.resultRank(winnerNumbers));

        int buyAmount = lottoTickets.getAll().size();
        float expectedRate = (float) rank.getReward() / (buyAmount * LOTTO_VALUE);
        assertThat(lottoResultBoard.getBenefitRate()).isEqualTo(expectedRate);
    }

}
