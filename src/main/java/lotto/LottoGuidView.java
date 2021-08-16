package lotto;

import java.io.BufferedReader;
import java.io.IOException;

public class LottoGuidView {

    public void getPurchaseAmount(BufferedReader br) throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        System.out.println((Integer.parseInt(br.readLine()) / Lotto.amount) + "개를 구매했습니다.");
    }

}
