package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {


    public static void main(String args[]) {
        Purchase purchase = new Purchase();
        List<List<LottoNumber>> purchaseNumList = new ArrayList<>();
        int[] winCount = new int[6];

        purchase.inputPurchaseAmount();
        int purchaseCount = purchase.getPurchaseCount(purchase.purchaseAmount);

        purchase.printPurchaseCount(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
            purchaseNumList.add(purchase.createAutoNumber());

            purchase.printPurchaseNumber();
        }

        purchase.inputWinNumber();

        for (int i = 0; i < purchaseCount; i++) {
            if(LottoGame.match(purchaseNumList.get(i), purchase.getWinningNumber(), purchase.getBonusBall()).equals(Rank.FIRST)) {
                winCount[0]++;
            }
            if(LottoGame.match(purchaseNumList.get(i), purchase.getWinningNumber(), purchase.getBonusBall()).equals(Rank.SECOND)) {
                winCount[1]++;
            }
            if(LottoGame.match(purchaseNumList.get(i), purchase.getWinningNumber(), purchase.getBonusBall()).equals(Rank.THIRD)) {
                winCount[2]++;
            }
            if(LottoGame.match(purchaseNumList.get(i), purchase.getWinningNumber(), purchase.getBonusBall()).equals(Rank.FOURTH)) {
                winCount[3]++;
            }
            if(LottoGame.match(purchaseNumList.get(i), purchase.getWinningNumber(), purchase.getBonusBall()).equals(Rank.FIFTH)) {
                winCount[4]++;
            }
        }
        purchase.printResult(winCount);

    }
}
