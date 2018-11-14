package raffle.view.web;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import raffle.domain.lotto.win.LottoResult;
import raffle.domain.lotto.win.WinLotto;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

public class ResultHelper implements Helper<LottoResult> {

    @Override
    public Object apply(LottoResult lottoResult, Options options) throws IOException {
        StringBuilder result = new StringBuilder();

        List<WinLotto> winLottos = asList(WinLotto.THREE_WIN_LOTTO, WinLotto.FOUR_WIN_LOTTO, WinLotto.FIVE_WIN_LOTTO, WinLotto.FIVE_WIN_BONUS_LOTTO, WinLotto.SIX_WIN_LOTTO);
        for(WinLotto winLotto : winLottos){
            String outPrint = "%d개 일치 (%d 원) - %d개";
            if(winLotto.equals(WinLotto.FIVE_WIN_BONUS_LOTTO)){
                outPrint = "%d개 일치, 보너스 볼 일치 (%d 원) - %d개";
            }
            result
                    .append("<tr>")
                    .append("<th>")
                    .append(String.format(outPrint ,
                    winLotto.getWinCount(), winLotto.getPrice(), lottoResult.getLottoCount(winLotto)))
                    .append("</th>")
                    .append("</th>");
        }
            result
                    .append("<tfoot>")
                    .append("<th>")
                    .append("<h4 class=\"text-center\">")
                    .append(String.format("총 수익률은 %.2f입니다.", lottoResult.getResultProfit()))
                    .append("</h4>")
                    .append("</th>")
                    .append("</tfoot>");

        return new Handlebars.SafeString(result.toString());
    }
}
