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
            System.out.println(String.format("%d개 일치 (%d 원) - %d개",
                    winLotto.getWinCount(), winLotto.getPrice(), lottoResult.getLottoCount(winLotto)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.getResultProfit()));
    }

    private static List<WinLotto> getWinLotto() {
        return asList(WinLotto.THREE_WIN_LOTTO, WinLotto.FOUR_WIN_LOTTO, WinLotto.FIVE_WIN_LOTTO, WinLotto.SIX_WIN_LOTTO);
    }
}
