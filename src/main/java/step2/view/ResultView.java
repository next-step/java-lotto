package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoNumber;
import step2.domain.winning.WinningScore;
import step2.domain.winning.WinningScoreBoard;
import step2.dto.LottoExpressionResponseDto;
import step2.dto.LottoWinningResultResponseDto;
import sun.lwawt.SecurityWarningWindow;

import java.util.Arrays;
import java.util.Collections;
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
        List<WinningScore> data = Arrays.stream(WinningScore.values()).collect(Collectors.toList());
        data.remove(WinningScore.MISS);
        for(WinningScore winningScore : data) {
            stringBuilder.append(winningScore.getCorrectCount()).append("개 일치");
            stringBuilder.append("(").append(winningScore.getWinningAmount()).append("원)");
            stringBuilder.append("-").append(winningScoreBoard.get(winningScore)).append("개\n");
        }
        stringBuilder.append("총 수익률은 ").append(0.35).append("입니다.");
        stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
        System.out.println(stringBuilder.toString());

    }
}
