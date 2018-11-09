package raffle.view;

import raffle.lotto.Lotto;
import raffle.lotto.win.LottoResult;
import raffle.lotto.win.WinLotto;

import java.util.List;

import static java.util.Arrays.asList;

public class ResultView {

    public void buyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto: lottos){
            System.out.println(lotto.getLottoNumber());
        }
    }

    public void result(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(WinLotto winLotto : getWinLotto()){
            String outPrint = "%d개 일치 (%d 원) - %d개";
            if(winLotto.equals(WinLotto.FIVE_WIN_BONUS_LOTTO)){
                outPrint = "%d개 일치, 보너스 볼 일치 (%d 원) - %d개";
            }
            System.out.println(String.format(outPrint ,
                    winLotto.getWinCount(), winLotto.getPrice(), lottoResult.getLottoCount(winLotto)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.getResultProfit()));
    }

    private static List<WinLotto> getWinLotto() {
        return asList(WinLotto.THREE_WIN_LOTTO, WinLotto.FOUR_WIN_LOTTO, WinLotto.FIVE_WIN_LOTTO, WinLotto.FIVE_WIN_BONUS_LOTTO, WinLotto.SIX_WIN_LOTTO);
    }

}
