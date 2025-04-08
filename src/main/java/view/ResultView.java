package view;

import java.util.List;

public class ResultView {
    public void printStat(List<String> stats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (String s : stats) {
            System.out.println(s);
        }
    }
}
