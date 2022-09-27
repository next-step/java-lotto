package lotto.controller;


import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    private static String RESULT_MSG = "당첨 통계\n---------";

    private static String PROFIT_MSG = "총 수익율은 %f 입니다.";


    static void printLottos(Lottos lottos){
        lottos.getLottos().stream().map(lotto -> lotto.getLotto()).forEach(System.out::println);
    }


}