package lotto;

import lotto.model.LottoGame;
import lotto.model.LottoNumbers;
import lotto.model.LottoTicket;
import lotto.type.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameTest {

    private static final String TEST_WINNING_NUMBER = "2,4,6,8,10,12";

    LottoGame lottoGame = new LottoGame();
    LottoTicket lottoTicket;


    @BeforeEach
    void settingGame() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoGame.settingWinningNumber(TEST_WINNING_NUMBER);
        LottoNumbers firstPrizeNumber = new LottoNumbers(TEST_WINNING_NUMBER);
        lottoNumbers.add(firstPrizeNumber);
        LottoNumbers secondPrizeNumber = new LottoNumbers("3,4,6,8,10,12");
        lottoNumbers.add(secondPrizeNumber);
        LottoNumbers thirdPrizeNumber = new LottoNumbers("3,5,6,8,10,12");
        lottoNumbers.add(thirdPrizeNumber);
        LottoNumbers unWinningNumber = new LottoNumbers("1,3,5,7,9,11");
        lottoNumbers.add(unWinningNumber);
        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @Test
    void 로또_구입_금액을_입력하면_로또_몇장() {
        assertThat(lottoGame.getLottoAmount(14000)).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    void 로또_산만큼_로또_자동_생성(int amount, int gameCount) {
        lottoGame.getLottoAmount(amount);
        LottoTicket lottoTicket = lottoGame.getLottoTicket();
        assertThat(lottoTicket.getTicketInfo().size()).isEqualTo(gameCount);
    }


    @ParameterizedTest
    @CsvSource(value = {"6:true", "5:true", "4:true", "3:false"}, delimiter = ':')
    void 당첨번호갯수별_로또_당첨_현황(int winningCount, boolean result) {
        Map<Winning, Integer> winningCountMap = lottoGame.setWinningCount(lottoTicket);
        assertThat(winningCountMap
                .containsKey(Winning.findByWinning(winningCount)))
                .isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"15000:4", "30000:2", "200000:0.3"}, delimiter = ':')
    void 수익률_계산(int amount, double profitRate) {
        lottoGame.getLottoAmount(amount);
        Map<Winning, Integer> winningMap = this.삼등_1개_4등_2개();
        assertThat(lottoGame.getMargin(winningMap))
                .isEqualTo(profitRate);
    }


    private Map<Winning, Integer> 삼등_1개_4등_2개() {
        Map<Winning, Integer> winningMap = new HashMap<>();
        winningMap.put(Winning.THIRD, 1);
        winningMap.put(Winning.FOURTH, 2);
        return winningMap;
    }

}
