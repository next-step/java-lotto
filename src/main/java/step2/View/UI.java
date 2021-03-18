package step2.View;

import step2.domain.Lotto;
import step2.dto.JudgeResponse;
import step2.dto.Money;
import step2.dto.Price;
import step2.dto.ShopResponse;

import java.util.Scanner;

public class UI {
    public Money getMoneyInput(){
        System.out.println("구입금액을 입력해주세요");
        int money = new Scanner(System.in).nextInt();
        return new Money(money);
    }

    public void printLottoAmount(ShopResponse shopResponse) {
        System.out.println(shopResponse.getLottoCount()+"개를 구매했습니다.");
    }


    public void printLottoNumbers(ShopResponse shopResponse) {
        shopResponse.getLottoList()
                .forEach((System.out::println));
    }

    public Lotto getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String values = new Scanner(System.in).next();
        return new Lotto(values);
    }

    public void printResult(JudgeResponse judgeResponse) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Price.threeMatchPrice + ")- "+judgeResponse.getThreeMatch());
        System.out.println("4개 일치 (" + Price.fourMatchPrice + ")- "+judgeResponse.getFourMatch());
        System.out.println("5개 일치 (" + Price.fiveMatchPrice + ")- "+judgeResponse.getFiveMatch());
        System.out.println("6개 일치 (" + Price.sixMatchPrice + ")- "+judgeResponse.getSixMatch());
        System.out.println("총 수익률은 "+judgeResponse.getProfitIndex()+"입니다.");
    }
}
