package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class LottoGuidView {

    public int getPurchaseAmount(BufferedReader br) throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int amountPaid = Integer.parseInt(br.readLine());

        System.out.println((amountPaid / LottoPurchasingMachine.amount) + "개를 구매했습니다.");

        return amountPaid;
    }

    public void showLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
}
