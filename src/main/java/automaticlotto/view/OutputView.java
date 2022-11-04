package automaticlotto.view;

import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String RESULT_TITLE = "당첨 통계\n---------";
    private static final String[] LOTTO_RESULT_SAME = {"3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000원) - ", "6개 일치 (2000000000원) - "};
    private static int totalMoney = 0;

    private OutputView() {

    }

    public static int showLottoNumber(int purchaseAmount) {
        int buyLottoNumbers = buyLottoNumber(purchaseAmount);
        System.out.println(buyLottoNumbers + "개를 구매했습니다.");
        return buyLottoNumbers;
    }

    private static int buyLottoNumber(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static void showBuyingLotto(List<List<String>> buyLotto) {
        for (List<String> lotto : buyLotto) {
            System.out.println(lotto);
        }
    }
}
