package step2;

import java.util.List;

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

    private void printEachLottery(Lottery lottery) {
    }

    /**
     * 구입한 복권 장 수를 출력하는 메소드
     * @param size 구입한 복권 개수
     */
    private void printNumberOfPurchased(int size) {
        System.out.println(size + Constants.OUTPUT_NUMBER_OF_PURCHASED_LOTTERY_MSG);
    }
}
