package lotto.controller;

import lotto.domain.lottoIssue;
import lotto.ui.inputView;

import java.util.List;
import java.util.Queue;

public class lottoMain {
    public static void main(String[] args) {
        inputView input = new inputView();
        input.inputPurchaseAmount();
        int amount = input.getPurchaseAmount();

        lottoIssue lotto = new lottoIssue(amount);
        int count = lotto.getCount();
        System.out.println(count + "개를 구매했습니다.");
        Queue<List> lottoList = lotto.publishLotto(count);
        for(List list:lottoList) {
            System.out.println(list);
        }

    }
}
