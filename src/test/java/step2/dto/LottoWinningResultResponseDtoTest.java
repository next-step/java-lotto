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

    @DisplayName("LottoWinningResultResponseDto 인스턴스 생성 검증 테스트")
    @Test
    void 생성 (){
        //given
        Map<WinningScore, Integer> testMap = new HashMap<>();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);

        // when
        LottoWinningResultResponseDto responseDto = LottoWinningResultResponseDto.newInstance(winningScoreBoard);

        // then
        assertThat(responseDto).isNotNull();
    }

}