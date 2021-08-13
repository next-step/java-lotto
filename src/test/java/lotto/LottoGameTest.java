package lotto;

import lotto.model.LottoGame;
import lotto.model.LottoNumbers;
import lotto.model.LottoTicket;
import lotto.model.ManualLottoNumbers;
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
    ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers();


    @BeforeEach
    void settingGame() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoGame.settingWinningNumber(TEST_WINNING_NUMBER, 1);
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add(TEST_WINNING_NUMBER);
        manualNumbers.add("1,4,6,8,10,12");
        manualNumbers.add("3,4,6,8,10,12");
        manualNumbers.add("3,5,7,9,11,13");
        manualLottoNumbers.setManualLottoNumbers(manualNumbers);
        lottoTicket = new LottoTicket(manualLottoNumbers, 0);
    }

    @Test
    void 로또_구입_금액을_입력하면_로또_몇장() {
        assertThat(lottoGame.getLottoAmount(14000)).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    void 로또_산만큼_로또_자동_생성(int amount, int gameCount) {
        lottoGame.getLottoAmount(amount);
        LottoTicket lottoTicket = lottoGame.getLottoTicket(null);
        assertThat(lottoTicket.getLottoTicketInfo().size()).isEqualTo(gameCount);
    }


    @ParameterizedTest
    @CsvSource(value = {"6:false:true", "5:true:true", "5:false:true", "3:false:false"}, delimiter = ':')
    void 당첨번호갯수별_로또_당첨_현황(int winningCount, boolean matchBonus, boolean result) {
        Map<Winning, Integer> winningCountMap = lottoGame.setWinningCount(lottoTicket);
        assertThat(winningCountMap
                .containsKey(Winning.findByWinning(winningCount, matchBonus)))
                .isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"15000:4", "30000:2", "200000:0.3"}, delimiter = ':')
    void 수익률_계산(int amount, double profitRate) {
        lottoGame.getLottoAmount(amount);
        Map<Winning, Integer> winningMap = this.사등_1개_오등_2개();
        assertThat(lottoGame.getMargin(winningMap))
                .isEqualTo(profitRate);
    }


    private Map<Winning, Integer> 사등_1개_오등_2개() {
        Map<Winning, Integer> winningMap = new HashMap<>();
        winningMap.put(Winning.FOURTH, 1);
        winningMap.put(Winning.FIFTH, 2);
        return winningMap;
    }

}
