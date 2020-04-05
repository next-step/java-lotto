package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoConstant;
import step2.domain.LottoWinningInfomation;
import step2.domain.LottoWinningInformations;

import java.util.List;

public class ResultView {

    public ResultView() {
    }

    public void printTickets(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottoTickets) {
            sb.append(LottoConstant.START_SEPERATOR);
            sb.append(printLottoNumber(lotto));
            sb.append(LottoConstant.END_SEPERATOR);
            sb.append(LottoConstant.ENTER);
        }
        print(sb.toString());
    }

    public String printLottoNumber(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(lotto.getNumbers().get(0));
        for (int i = 1; i < lotto.getNumbers().size(); i++) {
            sb.append(LottoConstant.SPLIT_SEPERATOR);
            sb.append(lotto.getNumbers().get(i));

        }
        return sb.toString();
    }

    public void printWinningInfo(LottoWinningInformations lottoWinningInformations) {
        StringBuilder sb = new StringBuilder();
        print(LottoConstant.RESULT_WINNING_MESSAGE);
        for (LottoWinningInfomation winningInformation : LottoWinningInfomation.values()) {
            sb.append(winningInformation.getDescription());
            sb.append(" ");
            sb.append("(" + winningInformation.getPrice() + " 원) - ");
            sb.append(lottoWinningInformations.getMatchingInformation().get(winningInformation) + " 개");
            sb.append("\n");
        }
        sb.append(String.format(
                "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)",
                lottoWinningInformations.getEarningRate()
        ));
        print(sb.toString());
    }


    public void print(String input) {
        System.out.println(input);
    }
}
