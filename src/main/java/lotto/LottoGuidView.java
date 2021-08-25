package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LottoGuidView {
    private final BufferedReader bufferedReader;

    public LottoGuidView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int getPurchaseAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int amountPaid = Integer.parseInt(this.bufferedReader.readLine());

        System.out.println((amountPaid / LottoPurchasingMachine.AMOUNT) + "개를 구매했습니다.");

        return amountPaid;
    }

    public int getManualNumberPurchase() throws IOException {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(this.bufferedReader.readLine());
    }

    public String[] enterManualNumberPurchase(int manualNumberPurchaseCount) throws IOException {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] result = new String[manualNumberPurchaseCount];
        for (int i = 0; i < manualNumberPurchaseCount; i++) {
            result[i] = this.bufferedReader.readLine();
        }
        return result;
    }

    public void showLottoList(int manualLottoCount, int automaticLottoCount, List<Lotto> lottoList) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, automaticLottoCount);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public List<String> getPrevWinningLottoNumbers() throws IOException {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.asList(this.bufferedReader.readLine().split(","));
    }

    public String enteredBonusBallNumber() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.bufferedReader.readLine();
    }

    public void showNumericalStatement(List<Integer> result , double yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(Rank.FOURTH.getMatchedCount() + "개 일치 (" + Rank.FOURTH.getPrizeMoney() + "원)- " + result.get(Rank.FOURTH.getPlaceIndex()) + "개");
        System.out.println(Rank.THIRD.getMatchedCount() + "개 일치 (" + Rank.THIRD.getPrizeMoney() + "원)- " + result.get(Rank.THIRD.getPlaceIndex()) + "개");
        System.out.println(Rank.SECOND.getMatchedCount() + "개 일치 (" + Rank.SECOND.getPrizeMoney() + "원)- " + result.get(Rank.SECOND.getPlaceIndex()) + "개");
        System.out.println(Rank.SECOND_BONUS.getMatchedCount() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND_BONUS.getPrizeMoney() + "원)- " + result.get(Rank.SECOND_BONUS.getPlaceIndex()) + "개");
        System.out.println(Rank.FIRST.getMatchedCount() + "개 일치 (" + Rank.FIRST.getPrizeMoney() + "원)- " + result.get(Rank.FIRST.getPlaceIndex()) + "개");
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
