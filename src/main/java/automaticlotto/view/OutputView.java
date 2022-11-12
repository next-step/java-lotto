package automaticlotto.view;

import automaticlotto.domain.Lotto;
import automaticlotto.domain.LottoNumber;
import automaticlotto.domain.Lottos;

import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String RESULT_TITLE = "당첨 통계\n---------";
    private static final String[] LOTTO_RESULT_SAME = {"3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000원) - ", "6개 일치 (2000000000원) - "};
    private static final String TOTAL_REWARD = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

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

    public static void showBuyingLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            System.out.println(showLottoNumber(lottoNumbers));
        }
    }

    private static String showLottoNumber(List<LottoNumber> lottoNumbers) {
        String randomLottoNumber = "[";
        for (LottoNumber lottoNumber : lottoNumbers) {
            randomLottoNumber += lottoNumber.getLottoNumber() + ",";
        }
        randomLottoNumber = randomLottoNumber.substring(0, randomLottoNumber.length() - 1);
        randomLottoNumber += "]";
        return randomLottoNumber;
    }

}
