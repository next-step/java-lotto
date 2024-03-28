package lotto.ui;

import lotto.domain.LottoList;
import lotto.match.LottoPrizeCount;
import lotto.match.LottoResult;
import lotto.prize.StandardPrizeRate;


import java.util.Scanner;

public class LottoShop {

    private final Scanner scanner = new Scanner(System.in);

    public String inputMoney(){
        System.out.println("구매 금액을 입력하세요");
        return scanner.nextLine();
    }

    public void printPurchaseLotto(LottoList lottoList){
        System.out.printf("%d개를 구매했습니다.",lottoList.size());
        System.out.println();
        lottoList.getLottoTextList().forEach(System.out::println);
    }

    public String inputAnswerSheet(){
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        return scanner.nextLine();
    }

    public String inputBonusNumber(){
        System.out.println("보너스 볼을 입력해주세요");
        return scanner.nextLine();
    }

    public void printResult(LottoResult lottoResult,int lottoValue){
        System.out.println("당첨 통계\n------");
        lottoResult.getResult()
                .stream()
                .map(LottoPrizeCount::getWord)
                .forEach(System.out::println);
        System.out.printf("총 수익률은 %.2f 입니다.",lottoResult.getWinningPercent(new StandardPrizeRate(), lottoValue));
    }
}
