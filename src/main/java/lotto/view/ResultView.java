package lotto.view;

import java.util.List;

public class ResultView {

    /**
     * 구매한 로또의 갯수를 출력합니다.
     * @param amount
     */
    public void printNumberOfPurchasedLotto(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    /**
     * 발급된 로또 번호를 출력합니다.
     * @param lottoNumbers
     */
    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
