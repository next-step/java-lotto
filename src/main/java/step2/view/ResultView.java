package step2.view;

import java.util.Map;

public class ResultView {

    public void winningNumberComment() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
    }

    public void printStatics(Map<Integer, Integer> countStore) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------");
        System.out.printf("3개 일치 (5000 원)- %d개", countStore.get(3)).println();
        System.out.printf("4개 일치 (50,000 원)- %d개", countStore.get(4)).println();
        System.out.printf("5개 일치 (1,500,000 원)- %d개", countStore.get(5)).println();
        System.out.printf("6개 일치 (2,000,000,000 원)- %d개", countStore.get(6)).println();
        System.out.println();
    }

    public void printProfit(String profitRate) {
        System.out.printf("총 수익률은 %s 입니다.", profitRate).println();
    }
}
