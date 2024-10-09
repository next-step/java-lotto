package view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    private static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void priceLottoResult(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        sb.append(lottos.size()).append("개를 구매했습니다.");
        sb.append(System.lineSeparator());
        for (Lotto lotto : lottos) {
            sb.append("[");
            getLottoNumber(sb, lotto);
            sb.append("]");
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private void getLottoNumber(StringBuilder sb, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            sb.append(lottoNumbers.get(i));
            sb.append(addComma(i, lottoNumbers.size() - 1));
        }
    }

    private static String addComma(int index, int lastIndex) {
        if (index != lastIndex) {
            return ", ";
        }
        return "";
    }
}
