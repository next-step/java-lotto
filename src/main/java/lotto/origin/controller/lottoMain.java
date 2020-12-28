package lotto.controller;

import lotto.domain.lottoIssue;
import lotto.ui.inputView;
import lotto.ui.resultView;

import java.util.*;

public class lottoMain {

    public static final String COMMA = ",";

    public static void main(String[] args) {
        inputView input = new inputView();
        input.inputPurchaseAmount();
        int amount = input.getPurchaseAmount();
        lottoIssue lotto = new lottoIssue(amount);
        int count = lotto.getCount();
        System.out.println(count + "개를 구매했습니다.");
        showLottoList(lotto, count);
        issueWinningNum(input);
        publishLottoStats(input, lotto);
        HashMap<Integer, Integer> stats = lotto.getLottoStats();
        resultView  result = new resultView(stats);
        result.displayStatsInfo();
    }

    private static void publishLottoStats(inputView input, lottoIssue lotto) {
        String[] winningNum = input.getWinningNum().split(COMMA);
        lotto.checkLotto(winningNum);
    }

    private static void issueWinningNum(inputView input) {
        System.out.println();
        input.inputWinningNum();
        System.out.println();
    }

    private static void showLottoList(lottoIssue lotto, int count) {
        Queue<ArrayList> lottoList = lotto.publishLotto(count);
        for(List list:lottoList) {
            System.out.println(list);
        }
    }
}
