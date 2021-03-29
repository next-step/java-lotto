package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoNumber;
import step2.domain.request.Money;
import step2.domain.winning.WinningScore;
import step2.domain.winning.WinningScoreBoard;
import step2.dto.LottoExpressionResponseDto;
import step2.dto.LottoWinningResultResponseDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {

    private static ResultView instance;
    private final StringBuilder stringBuilder;
    private final double DIGIT_FORMAT = 100.0;

    public final static ResultView getInstance() {
        if (isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    private ResultView() {
        stringBuilder = new StringBuilder();
    }

    public final void printLottoList(LottoExpressionResponseDto expressionResponseDto) {
        stringBuilderReset();
        LottoList lottoList = expressionResponseDto.getLottoList();
        List<Lotto> list = lottoList.getLottoList();
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

    private void stringBuilderReset(){
        stringBuilder.setLength(0);
    }

    public final void printLottoResult(LottoWinningResultResponseDto lottoWinningResultResponseDto, Money money) {
        stringBuilderReset();
        WinningScoreBoard winningScoreBoard = lottoWinningResultResponseDto.getWinningScoreBoard();
        stringBuilder.append("당첨 통계\n");
        stringBuilder.append("---------\n");
        List<WinningScore> data = Arrays.stream(WinningScore.values()).collect(Collectors.toList());
        data.remove(WinningScore.MISS);

        for(WinningScore winningScore : data) {
            stringBuilder.append(winningScore.getCorrectCount()).append("개 일치");
            stringBuilder.append("(").append(winningScore.getWinningAmount()).append("원)");
            stringBuilder.append("-").append(winningScoreBoard.get(winningScore)).append("개\n");
        }

        double yield = doubleFormatting(getYield(winningScoreBoard, money.getMoney()));
        stringBuilder.append("총 수익률은 ").append(yield).append("입니다.");
        stringBuilder.append("(기준이 1이기 때문에 결과적으로 ").append(chekProfitOrLoss(yield)).append("라는 의미임)");
        System.out.println(stringBuilder.toString());

    }

    public final double getYield(WinningScoreBoard winningScoreBoard, int inputMoney) {
        return ((double)getRevenue(winningScoreBoard) / (double)inputMoney);
    }

    private final int getRevenue(WinningScoreBoard winningScoreBoard) {
        int sum = 0;
        for (WinningScore winningScore : WinningScore.values()) {
            sum += Math.multiplyExact(winningScore.getWinningAmount(), winningScoreBoard.get(winningScore));
        }
        return sum;
    }

    private String chekProfitOrLoss(double yield) {
        return yield >= 1 ? "이익이" : "손해";
    }

    private double doubleFormatting(double yield){
        return (Math.floor(yield*DIGIT_FORMAT))/DIGIT_FORMAT;
    }

}
