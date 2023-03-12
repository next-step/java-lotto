package lotto.domain;

import java.util.*;

public class LottoMachine {
    private static final int PURCHASE_UINT_AMOUNT = 1000;


    private int winning3 = 0;
    private int winning4 = 0;
    private int winning5 = 0;
    private int winningBonus5 = 0;
    private int winning6 = 0;
    private List<Integer> winningNums;
    private int bonusNum;


    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.runLottoMachine();
    }

    public void runLottoMachine() {
        int purchaseAmt = enterPurchaseAmount();
        int purchaseCnt = getPuchaseCount(purchaseAmt);

        enterWinningsAndBonusNumbers();

        for (int cnt = 1; cnt <= purchaseCnt; cnt++) {
            getLottoNumbers();
        }

        printWinningResult();
        printWinningRate(purchaseAmt);

    }

    private void getLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> lottoResult = lottoNumbers.getLottoNumbers().subList(0, 6);
        Collections.sort(lottoResult);

        int winningCnt = 0, bonusCnt = 0;
        for (int winningNum : winningNums) {
            if (lottoResult.contains(winningNum)) {
                winningCnt++;
            }
            if (lottoResult.contains(bonusNum)) {
                bonusCnt++;
            }
        }

        if (winningCnt == 3) winning3++;
        if (winningCnt == 4) winning4++;
        if (winningCnt == 5) winning5++;
        if (winningCnt == 5 && bonusCnt == 1) winning6++;
        if (winningCnt == 6) winning6++;

        System.out.println(lottoResult.toString());
    }


    private int enterPurchaseAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = sc.nextInt();


        validateNumber(purchaseAmount);

        return purchaseAmount;
    }

    private void validateNumber(int num) {
        if (num < PURCHASE_UINT_AMOUNT) {
            throw new IllegalArgumentException("로또 구입금액은 최소 1000원입니다.");
        }
        if (num % PURCHASE_UINT_AMOUNT > 0) {
            throw new IllegalArgumentException("로또 구입가능한 단위는 1000원입니다.");
        }
    }

    private int getPuchaseCount(int purchaseAmount) {
        int purchaseCount = purchaseAmount / 1000;
        System.out.println(purchaseCount + "개를 구매했습니다.");

        return purchaseCount;
    }

    private void enterWinningsAndBonusNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String winingNumbers = sc.nextLine();
        winningNums = new ArrayList<>();

        for (String strNum : winingNumbers.trim().split(",")) {
            winningNums.add(Integer.parseInt(strNum));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNum = sc.nextInt();
    }

    private void printWinningResult() {
        System.out.println("3개 일치 (5000원)- " + winning3 + "개");
        System.out.println("4개 일치 (50000원)- " + winning4 + "개");
        System.out.println("5개 일치 (1500000원)- " + winning5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningBonus5 + "개");
        System.out.println("6개 일치 (2000000000원)- " + winning6 + "개");
    }

    private void printWinningRate(int purchaseAmt) {
        double result = (winning3 * 5000 + winning4 * 50000 + winning5 * 1500000 + winningBonus5 * 30000000 + winning6 * 2000000000) / (double) purchaseAmt;
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 " + result + "입니다.");
        if (result < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(sb);
    }
}
