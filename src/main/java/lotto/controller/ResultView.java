package lotto.controller;

import lotto.model.Lotto;

import java.util.List;

public class ResultView {
    public void printBoughtResult(List<Lotto> lottoList) {
        StringBuilder result = new StringBuilder();
        result.append(lottoList.size())
                .append("개를 구매했습니다.");
        System.out.println(result);
    }
}
