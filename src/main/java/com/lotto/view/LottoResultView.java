package com.lotto.view;

import com.lotto.model.Lotto;
import com.lotto.model.UserLottos;
import com.lotto.model.WinningLotto;

import java.util.List;

public class LottoResultView {

    private static final String NUMBER_OF_LOTTO_PURCHASED = "%d개를 구매했습니다.%n";
    private static final String WINNING_RATE = "%n당첨 통계%n";
    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5000원)- %d개%n";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50000원)- %d개%n";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1500000원)- %d개%n";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2000000000원)- %d개%n";
    private static final String GROSS_YUELD_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";
    private static final int THREE_MATCH_COUNT = 3;
    private static final int FOUR_MATCH_COUNT = 4;
    private static final int FIVE_MATCH_COUNT = 5;
    private static final int SIX_MATCH_COUNT = 6;

    private final UserLottos userLottos;

    public LottoResultView(UserLottos userLottos) {
        this.userLottos = userLottos;
    }

    public void printUserLottos() {
        System.out.printf(NUMBER_OF_LOTTO_PURCHASED, userLottos.size());
        String[] lottos = userLottos.printUserLottos()
                                    .split(UserLottos.DELIMITER_STRING);
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningRate(WinningLotto winningLotto, int money) {
        userLottos.match(winningLotto);

        System.out.printf(WINNING_RATE);
        System.out.println("---------");
        System.out.printf(THREE_MATCH_MESSAGE, userLottos.getCountOf(THREE_MATCH_COUNT));
        System.out.printf(FOUR_MATCH_MESSAGE, userLottos.getCountOf(FOUR_MATCH_COUNT));
        System.out.printf(FIVE_MATCH_MESSAGE, userLottos.getCountOf(FIVE_MATCH_COUNT));
        System.out.printf(SIX_MATCH_MESSAGE, userLottos.getCountOf(SIX_MATCH_COUNT));
        System.out.printf(GROSS_YUELD_MESSAGE, userLottos.getRate(money));
    }

}
