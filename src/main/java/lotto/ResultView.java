package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoStatics;

import java.util.List;

public class ResultView {

    public void showNumberOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void showLottos(List<LottoNumber> numbers) {
        System.out.print(numbers.toString());
        System.out.println();
    }

    public void showWinStatics(LottoStatics[] lottoStatics, double profit) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------");

        for (LottoStatics lottoStatic: lottoStatics) {
            System.out.println(
                    lottoStatic.getWinningMatchCount() +"개 일치 (" + lottoStatic.getMoney() + "원)- " + lottoStatic.getCount()+ "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "입니다.");
    }

}
