package step3.view;

import java.util.List;
import step3.model.Lotto;
import step3.model.LottoBundle;
import step3.model.LottoNumber;

public class OutputView {

    private static final String BUNDLE_COUNT_MESSAGE = "%d 개를 구매했습니다.\n";

    public static void print(LottoBundle lottoBundle) {
        List<Lotto> lottoList = lottoBundle.getLottoList();
        System.out.printf(BUNDLE_COUNT_MESSAGE, lottoList.size());
        for (Lotto lotto : lottoList) {
            print(lotto);
        }
    }

    private static void print(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        StringBuilder sb = getLottoPrintFormat(lottoNumbers);
        System.out.println(sb);
    }

    private static StringBuilder getLottoPrintFormat(List<LottoNumber> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb;
    }

    private OutputView() {
    }
}
