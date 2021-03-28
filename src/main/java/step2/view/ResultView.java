package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoNumber;
import step2.domain.winning.WinningScore;
import step2.domain.winning.WinningScoreBoard;
import step2.dto.LottoExpressionResponseDto;
import step2.dto.LottoWinningResultResponseDto;
import sun.lwawt.SecurityWarningWindow;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {

    private static ResultView instance;

    public final static ResultView getInstance() {
        if (isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    public final void printLottoList(LottoExpressionResponseDto expressionResponseDto) {
        LottoList lottoList = expressionResponseDto.getLottoList();
        List<Lotto> list = lottoList.getLottoList();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(list.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotto : list) {
            stringBuilder.append(joinLottoNumbers(lotto));
        }
        System.out.println(stringBuilder.toString());
    }

    private String joinLottoNumbers(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers
                .stream()
                .map(lottoNumber -> lottoNumber.getLottoNumber())
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]\n"));
    }

    public final void printLottoResult(LottoWinningResultResponseDto lottoWinningResultResponseDto) {
        WinningScoreBoard winningScoreBoard = lottoWinningResultResponseDto.getWinningScoreBoard();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계\n");
        stringBuilder.append("---------\n");
        for(WinningScore winningScore : WinningScore.values()) {
            stringBuilder.append(winningScore.get)
            3개 일치 (5000원)- 1개

        }

        winningScoreBoard.get(WinningScore.THREE);
        winningScoreBoard.get(WinningScore.FIVE);
        winningScoreBoard.get(WinningScore.THREE);
        winningScoreBoard.get(WinningScore.SIX);

    }
}
