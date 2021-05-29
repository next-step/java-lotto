package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {

    @ParameterizedTest
    @DisplayName("게임 결과 테스트_보너스볼 불일치")
    @CsvSource(value = {"'1,2,3,4,5,6':'6'", "'1,2,3,4,5,7':'5'", "'1,2,3,4,7,8':'4'", "'1,2,3,7,8,9':'3'",
            "'1,2,7,8,9,10':'2'", "'1,7,8,9,10,11':'1'", "'7,8,9,10,11,12':'0'"}, delimiter = ':')
    void getGameResult_notMatchingBonusNumber(String lottoNumber, int matchCount) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 30);
        List<LottoTicket> userLottoTickets = Arrays.asList(new LottoTicket(lottoNumber));

        List<GameWinningResult> gameWinningResults = new GameResult().getGameResult(winningLottoTicket, userLottoTickets);
        GameWinningResult expectedGameWinningResults = new GameWinningResult(WinningType.of(matchCount, false), 1);
        assertThat(gameWinningResults).contains(expectedGameWinningResults);
    }

    @ParameterizedTest
    @DisplayName("게임 결과 테스트_보너스볼 일치")
    @CsvSource(value = {"'1,2,3,4,5,6':'6'", "'1,2,3,4,5,7':'5'", "'1,2,3,4,7,8':'4'", "'1,2,3,7,8,9':'3'",
            "'1,2,7,8,9,10':'2'", "'1,7,8,9,10,11':'1'", "'7,8,9,10,11,12':'0'"}, delimiter = ':')
    void getGameResult_matchingBonusNumber(String lottoNumber, int matchCount) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);
        List<LottoTicket> userLottoTickets = Arrays.asList(new LottoTicket(lottoNumber));

        List<GameWinningResult> gameWinningResults = new GameResult().getGameResult(winningLottoTicket, userLottoTickets);
        GameWinningResult expectedGameWinningResult = new GameWinningResult(WinningType.of(matchCount, true), 1);
        assertThat(gameWinningResults).contains(expectedGameWinningResult);
    }

    @Test
    @DisplayName("게임 결과 테스트_개수 확인")
    void getGameResult_countWinningResult() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);
        //순서대로 1등, 2등, 3등, 4등, 5등, MISS 로또 티켓
        List<LottoTicket> firstUserLottoTickets = Arrays.asList(new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,7"),
                new LottoTicket("1,2,3,4,5,8"), new LottoTicket("1,2,3,4,7,8"),
                new LottoTicket("1,2,3,7,8,9"), new LottoTicket("1,2,8,9,10,11"));

        List<GameWinningResult> firstMatchCountResults = new GameResult().getGameResult(winningLottoTicket, firstUserLottoTickets);
        for(int i = 0; i<=6; i++) {
            GameWinningResult expectedGameWinningResult = new GameWinningResult(WinningType.of(i, false), 1);
            assertThat(firstMatchCountResults).contains(expectedGameWinningResult);
        }

        //순서대로 1등, 2등, 2등, 5등, MISS, MISS 로또 티켓
        List<LottoTicket> secondUserLottoTickets = Arrays.asList(new LottoTicket("3,5,1,4,2,6"), new LottoTicket("1,2,3,4,5,7"),
                new LottoTicket("5,2,3,4,1,7"), new LottoTicket("2,1,3,8,9,7"),
                new LottoTicket("11,12,13,14,15,16"), new LottoTicket("10,8,2,9,1,11"));


        List<GameWinningResult> secondMatchCountResults = new GameResult().getGameResult(winningLottoTicket, secondUserLottoTickets);
        List<GameWinningResult> expectedGameWinningResults = new ArrayList<>();
        expectedGameWinningResults.add(new GameWinningResult(WinningType.FIRST, 1));
        expectedGameWinningResults.add(new GameWinningResult(WinningType.SECOND, 2));
        expectedGameWinningResults.add(new GameWinningResult(WinningType.THIRD, 0));
        expectedGameWinningResults.add(new GameWinningResult(WinningType.FORTH, 0));
        expectedGameWinningResults.add(new GameWinningResult(WinningType.FIFTH, 1));
        expectedGameWinningResults.add(new GameWinningResult(WinningType.MISS, 2));

        assertThat(secondMatchCountResults).isEqualTo(expectedGameWinningResults);
    }
}
