package step2.view;

import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;

public class OutputView {

    public static void outputMessageLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder builder = new StringBuilder()
                .append(lottoNumbers.getLottoNumbers().size())
                .append("개를 구매했습니다.");
        System.out.println(builder.toString());

        for (LottoNumber number : lottoNumbers.getLottoNumbers()) {
            System.out.println(number);
        }
    }
}
