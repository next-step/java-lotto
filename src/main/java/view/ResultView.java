package view;

import model.Lottos;

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

    public void printLottos(Lottos lottos) {

    }

    public List<String> getStatStrings() {
        return List.of(
//                String.format("%d개 일치 (%d원)- %d개", FOURTH_PLACE_MATCH, FOURTH_PLACE_PRIZE, fourthPlace),
//                String.format("%d개 일치 (%d원)- %d개", THIRD_PLACE_MATCH, THIRD_PLACE_PRIZE, thirdPlace),
//                String.format("%d개 일치 (%d원)- %d개", SECOND_PLACE_MATCH, SECOND_PLACE_PRIZE, secondPlace),
//                String.format("%d개 일치 (%d원)- %d개", FIRST_PLACE_MATCH, FIRST_PLACE_PRIZE, firstPlace),
//                getYieldString()
        );
    }

    private String getYieldString() {
//        int totalPrize = firstPlace * FIRST_PLACE_PRIZE + secondPlace * SECOND_PLACE_PRIZE + thirdPlace * THIRD_PLACE_PRIZE + fourthPlace * FOURTH_PLACE_PRIZE ;
//        double yieldRatio = (double) totalPrize / ((firstPlace + secondPlace + thirdPlace + fourthPlace + fifthPlace) * LOTTO_PRICE);
//        String result = "총 수익률은 " + yieldRatio + "입니다.";

//        if (yieldRatio == 1) {
//            return result + "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
//        }
//        if (yieldRatio > 1) {
//            return result + "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
//        }
//        return result + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
//    }
}
