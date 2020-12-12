package step2.view;

import step2.domain.LottoGame;
import step2.util.Constants;
import step2.domain.Lottery;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    /**
     * 구입한 복권을 출력하는 메소드
     * @param lotteryList 자동으로 발행된 복권 리스트
     */
    public void showPurchasedLottery(List<Lottery> lotteryList) {
        printNumberOfPurchased(lotteryList.size());
        
        for (Lottery lottery : lotteryList) {
            printEachLottery(lottery);
        }
    }

    /**
     * 각 복권을 출력하는 메소드
     * @param lottery 개별 복권
     */
    private void printEachLottery(Lottery lottery) {
        System.out.print(Constants.OPEN_BRACKET);
        System.out.print(lottery.getSelectedNumbers().stream()
                                                    .map(Object::toString)
                                                    .collect(Collectors.joining(Constants.COMMA_DELIMITER)));
        System.out.println(Constants.CLOSE_BRACKET);
    }

    /**
     * 구입한 복권 장 수를 출력하는 메소드
     * @param size 구입한 복권 개수
     */
    private void printNumberOfPurchased(int size) {
        System.out.println(size + Constants.OUTPUT_NUMBER_OF_PURCHASED_LOTTERY_MSG);
    }

    /**
     * 로또 결과를 출력하는 메소드
     * @param matchedResult 당첨 결과
     * @param profitRate 수익률
     */
    public void showResult(Map<Lottery, Integer> matchedResult, float profitRate) {
        printResultMessage();

        for (int i = 3; i <= 6; i++) {
            System.out.print(i + "개 일치 (" + LottoGame.prizeMoney.get(i) + ")- ");
            System.out.println(getOccurrence(matchedResult, i) + "개");
        }

        printProfitRate(profitRate);
    }

    /**
     * ResultView UI 출력 메시지
     */
    private void printResultMessage() {
        System.out.println();
        System.out.println(Constants.RESULT_MESSAGE);
        System.out.println(Constants.RESULT_LINE);
    }

    /***
     * 로또 묶음 중 일치하는 장 수 반환하는 메소드
     * @param matchedResult 일치 여부 map
     * @param number 몇 개 일치하는지 숫자
     * @return 일치하는 복권의 장 수 (개수)
     */
    private int getOccurrence(Map<Lottery, Integer> matchedResult, int number) {
        return (int) matchedResult.values().stream().filter(count -> number == count).count();
    }

    /**
     * 손해인지 이익인지 계산하는 메소드
     * @param profitRate 수익률
     * @return 손해인지 이익인지 반환
     */
    private String getLossOrGain(float profitRate) {
        if (profitRate >= 1) {
            return Constants.GAIN;
        }
        return Constants.LOSS;
    }

    /**
     * 수익률을 출력하는 메소드
     * @param profitRate 수익률
     */
    private void printProfitRate(float profitRate) {
        System.out.print("총 수익률은 " + profitRate + "입니다.");
        System.out.println(" (기준이 1이기 때문에 결과적으로는 " + getLossOrGain(profitRate) + "(이)라는 의미임)");
    }
}
