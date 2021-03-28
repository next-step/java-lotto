package step2.dto;

import step2.domain.winning.WinningScoreBoard;

public class LottoWinningResultResponseDto {

    private final WinningScoreBoard winningScoreBoard;

    public static LottoWinningResultResponseDto newInstance(WinningScoreBoard winningScoreBoard) {
        return new LottoWinningResultResponseDto(winningScoreBoard);
    }

    private LottoWinningResultResponseDto(WinningScoreBoard winningScoreBoard) {
        this.winningScoreBoard = winningScoreBoard;
    }

    public WinningScoreBoard getWinningScoreBoard() {
        return winningScoreBoard;
    }

}
