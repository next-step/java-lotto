package lotto;

import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class LottoClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoPrice lottoPrice = new LottoPrice();
        Lotto lotto = new Lotto();

        int lottos = lottoPrice.lottos(Integer.parseInt(inputView.inputQuestion("구입금액을 입력해 주세요.")));
        inputView.print(lottos + "개를 구매했습니다.");
        lotto.buy(lottos);

        for (LottoNumbers marked : lotto.lotto()) {
            System.out.println(marked.toString());
        }

        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputQuestion("지난 주 당첨 번호를 입력해 주세요.").replaceAll(" ", "").split(","));

        inputView.print("당첨 통계");
        inputView.print("---------");
        Map<Integer, Integer> winNumbers = winningNumbers.getWinNumbers(lotto);
        System.out.println("3개 일치 (5000원)- " + winNumbers.get(3) +"개");
        System.out.println("4개 일치 (50000원)- " + winNumbers.get(4) +"개");
        System.out.println("5개 일치 (1500000원)- " + winNumbers.get(5) +"개");
        System.out.println("6개 일치 (2000000000원)- " + winNumbers.get(6) +"개");
        System.out.println("총 수익률은 0.35입니다.");
    }
}
