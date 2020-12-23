package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBucket;
import lotto.domain.WinningLottoType;
import lotto.domain.WinningLottos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayView {

    private static final String NUMBER_OF_LOTTO = "개를 구매 했습니다.";

    private DisplayView(){}

    public static void exchangeLottoMsg(int numberOfLotto){
        System.out.println(numberOfLotto + NUMBER_OF_LOTTO);
    }

    public static void showLottoBuckets(LottoBucket lottoBucket){
        List<Lotto> lottos = lottoBucket.getLottos();
        lottos.forEach( (lotto) -> {
            String lottoNumber = lotto.showLottoNumber().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"));
            println(lottoNumber);
        });
    }
    public static void showWinningStatis(WinningLottos winningLottos){
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
        builder.append(winningLottoType.getName()+"개 일치 ");
        builder.append("("+winningLottoType.getWinnerMoney()+")");
        builder.append("- "+matchNumberOfCount+"개");
        System.out.println(builder.toString());
    }

    public static void printRevenu(BigDecimal calcurateRevenue) {
        println("총 수익률은 "+ calcurateRevenue+"입니다.");
    }
}
