package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoGamePlayerTest {

    @ParameterizedTest
    @DisplayName("게임 결과 테스트_보너스볼 불일치")
    @CsvSource(value = {"'1,2,3,4,5,6':'6'", "'1,2,3,4,5,7':'5'", "'1,2,3,4,7,8':'4'", "'1,2,3,7,8,9':'3'",
            "'1,2,7,8,9,10':'2'", "'1,7,8,9,10,11':'1'", "'7,8,9,10,11,12':'0'"}, delimiter = ':')
    void getGameResult_notMatchingBonusNumber(String lottoNumber, int matchCount) {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTickets userLottoTickets = new LottoTickets(
                Arrays.asList(new LottoTicket(lottoNumber)));

        Map<WinningType, Integer> matchCountResults = new LottoGamePlayer().getGameResult(winningLottoTicket, userLottoTickets, 30);
        assertThat(matchCountResults.keySet()).contains(WinningType.of(matchCount, false));
    }

    @ParameterizedTest
    @DisplayName("게임 결과 테스트_보너스볼 일치")
    @CsvSource(value = {"'1,2,3,4,5,6':'6'", "'1,2,3,4,5,7':'5'", "'1,2,3,4,7,8':'4'", "'1,2,3,7,8,9':'3'",
            "'1,2,7,8,9,10':'2'", "'1,7,8,9,10,11':'1'", "'7,8,9,10,11,12':'0'"}, delimiter = ':')
    void getGameResult_matchingBonusNumber(String lottoNumber, int matchCount) {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTickets userLottoTickets = new LottoTickets(
                Arrays.asList(new LottoTicket(lottoNumber)));

        Map<WinningType, Integer> matchCountResults = new LottoGamePlayer().getGameResult(winningLottoTicket, userLottoTickets, 7);
        assertThat(matchCountResults.keySet()).contains(WinningType.of(matchCount, true));
    }

    @Test
    @DisplayName("게임 결과 테스트_개수 확인")
    void getGameResult_countWinningResult() {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        //순서대로 1등, 2등, 3등, 4등, 5등, MISS 로또 티켓
        LottoTickets firstUserLottoTickets = new LottoTickets(
                Arrays.asList(new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,7"),
                        new LottoTicket("1,2,3,4,5,8"), new LottoTicket("1,2,3,4,7,8"),
                        new LottoTicket("1,2,3,7,8,9"), new LottoTicket("1,2,8,9,10,11")));

        Map<WinningType, Integer> firstMatchCountResults = new LottoGamePlayer().getGameResult(winningLottoTicket, firstUserLottoTickets, 7);
        assertThat(firstMatchCountResults.values()).containsExactly(1,1,1,1,1,1);

        //순서대로 1등, 2등, 2등, 5등, MISS, MISS 로또 티켓
        LottoTickets secondUserLottoTickets = new LottoTickets(
                Arrays.asList(new LottoTicket("3,5,1,4,2,6"), new LottoTicket("1,2,3,4,5,7"),
                        new LottoTicket("5,2,3,4,1,7"), new LottoTicket("2,1,3,8,9,7"),
                        new LottoTicket("11,12,13,14,15,16"), new LottoTicket("10,8,2,9,1,11")));

        Map<WinningType, Integer> secondMatchCountResults = new LottoGamePlayer().getGameResult(winningLottoTicket, secondUserLottoTickets, 7);
        assertThat(secondMatchCountResults.values()).containsExactly(1,2,0,0,1,2);
    }

    @Test
    @DisplayName("보너스볼 입력 테스트")
    void inputBonusNumber_shouldNotIncludedWinningLottoNumber() {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTickets userLottoTickets = new LottoTickets(1);
        assertThatThrownBy(()->new LottoGamePlayer().getGameResult(winningLottoTicket, userLottoTickets,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
    }
}
