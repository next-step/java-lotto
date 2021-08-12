package step2.view;

import step2.model.WinningRule;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void showLotto(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public void showResult(Map<Integer, Integer> result, String winningRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        
        for (WinningRule rule : WinningRule.values()) {
            int count = rule.getNumberCount();
            int price = rule.getWinningPrice();
            System.out.println(count + "개 일치 (" + price + "원)-" +result.get(count) +"개");
        }
        System.out.println("총 수익률은 "+ winningRate +"입니다.");
    }
}
