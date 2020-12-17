package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBucket;
import lotto.domain.WinningLottos;

import java.util.List;

public class DisplayView {

    private static final String INPUT_MONEY_INFO = "구입 금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO = "개를 구매 했습니다.";

    private static final String INPUT_LAST_WINNINGNUMBER = "지난 주 당첨 번호를 입력해 주세요. ";

    public static void showInputMoneyInfo(){
        System.out.println(INPUT_MONEY_INFO);
    }

    public static void exchangeLottoMsg(int numberOfLotto){
        System.out.println(numberOfLotto + NUMBER_OF_LOTTO);
    }

    public static void showLottoBuckets(LottoBucket lottoBucket){
        List<Lotto> lottos = lottoBucket.getLottos();
        lottos.forEach(System.out::println);
    }

    public static void showInputLastWinningNumber() {
        System.out.println(INPUT_LAST_WINNINGNUMBER);
    }

    public static void showWinningStatis(WinningLottos winningLottos){
        println("당첨 통계");
        println("-----------");
        printlnMatchNumberAndMoney(3,5000,winningLottos.getNumberOfMatchThree());
        printlnMatchNumberAndMoney(4,50000,winningLottos.getNumberOfMatchFour());
        printlnMatchNumberAndMoney(5,1500000,winningLottos.getNumberOfMatchFive());
        printlnMatchNumberAndMoney(6,2000000000,winningLottos.getNumberOfMatchSix());
    }
    private static void println(String msg){
        System.out.println(msg);
    }
    private static void printlnMatchNumberAndMoney(int matchNumber,
                                                   long amountOfMoney,
                                                   int matchNumberOfCount){
        StringBuilder builder = new StringBuilder();
        builder.append(matchNumber+"개 일치 ");
        builder.append("("+amountOfMoney+")");
        builder.append("- "+matchNumberOfCount+"개");
        System.out.println(builder.toString());
    }

    public static void printRevenu(float calcurateRevenue) {
        println("총 수익률은 "+ calcurateRevenue+"입니다.");
    }
}
