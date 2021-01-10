package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayView {

    private static final String NUMBER_OF_LOTTO = "개를 구매 했습니다.";
    private static final String MANUAL_BUY_LOTTO = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INPUT_LOTTONUMBER = "수동으로 구매할 번호를 입력해주세요.";

    private DisplayView(){}

    public static void exchangeLottoMsg(int numberOfLotto){
        System.out.println(numberOfLotto + NUMBER_OF_LOTTO);
    }

    public static void showLottoBuckets(LottoBucket lottoBucket){
        List<Lotto> lottos = lottoBucket.getLottos();
        lottos.forEach( (lotto) -> {

            String lottoNumber = lotto.showLottoNumber().stream()
                    .map( LottoNumber::toString)
                    .collect(Collectors.joining(",", "[", "]"));

            println(lottoNumber);
        });
    }
    public static void showWinningStatics(WinningLottos winningLottos){
        println("당첨 통계");
        println("-----------");
        Map<WinningLottoType, Integer> winningLottoTypeByCountMap = winningLottos.getWinningLottoTypeByCountMap();
        winningLottoTypeByCountMap.entrySet().forEach( (element) -> {
            printlnMatchNumberAndMoney(element.getKey(), element.getValue());
        } );
    }
    private static void println(String msg){
        System.out.println(msg);
    }

    private static void printlnMatchNumberAndMoney(WinningLottoType winningLottoType, Integer matchNumberOfCount){
        StringBuilder builder = new StringBuilder();
        builder.append(winningLottoType.getName()+" 일치 ");
        builder.append("("+winningLottoType.getWinnerMoney()+")");
        builder.append("- "+matchNumberOfCount+"개");
        System.out.println(builder.toString());
    }

    public static void printRevenu(BigDecimal calcurateRevenue) {
        println("총 수익률은 "+ calcurateRevenue+"입니다.");
    }

    public static void showManualLotto() {
        println(MANUAL_BUY_LOTTO);
    }
    public static void inputManualLottoNumber(){
        println(INPUT_LOTTONUMBER);
    }

    public static void exchangeLottoMsg(int countOfManualLotto, int countOfAutoLotto) {
        String result = String.format("수동으로 %d 장, 자동으로 %d 개를 구매 했습니다",countOfManualLotto,countOfAutoLotto);
        println(result);
    }
}
