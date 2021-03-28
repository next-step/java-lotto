package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.winning.WinningScore;
import step2.domain.winning.WinningScoreBoard;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningResultResponseDtoTest {

    @DisplayName("LottoWinningResultResponseDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        //given
        Map<WinningScore, Integer> testMap = new HashMap<>();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);

        // when
        LottoWinningResultResponseDto responseDto = LottoWinningResultResponseDto.newInstance(winningScoreBoard);

        // then
        assertThat(responseDto).isNotNull();
    }

    @DisplayName("LottoWinningResultResponseDto 인스턴스 소유값 반환 여부 테스트")
    @Test
    void 반환() {
        //given
        Map<WinningScore, Integer> expected = new HashMap<>();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(expected);

        // when
        LottoWinningResultResponseDto responseDto = LottoWinningResultResponseDto.newInstance(winningScoreBoard);
        Map<WinningScore, Integer> actual = responseDto.getWinningScoreBoard();

        // then
        assertThat(actual).isEqualTo(expected);
    }


}