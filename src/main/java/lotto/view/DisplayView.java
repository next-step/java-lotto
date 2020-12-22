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
        ;
        //TODO 피드백에서 WinningLottos의 winningTypeCountMap을 활용하여 출력하는 방법이 의도하신게 맞는지 물어보기
        printlnMatchNumberAndMoney(WinningLottoType.MATCH_THREE, winningLottos.getWinningLottoTypeByCountMap(WinningLottoType.MATCH_THREE));
        printlnMatchNumberAndMoney(WinningLottoType.MATCH_FOUR, winningLottos.getWinningLottoTypeByCountMap(WinningLottoType.MATCH_FOUR));
        printlnMatchNumberAndMoney(WinningLottoType.MATCH_FIVE, winningLottos.getWinningLottoTypeByCountMap(WinningLottoType.MATCH_FIVE));
        printlnMatchNumberAndMoney(WinningLottoType.MATCH_FIVE_BONUS, winningLottos.getWinningLottoTypeByCountMap(WinningLottoType.MATCH_FIVE_BONUS));
        printlnMatchNumberAndMoney(WinningLottoType.MATCH_SIX, winningLottos.getWinningLottoTypeByCountMap(WinningLottoType.MATCH_SIX));
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
