package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.LottoResult;
import lotto.enums.LottoWinnerPrice;

import java.util.List;
import java.util.stream.Collectors;

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

    public void priceLottoStatus(List<Lotto> lottos) {

        String sb = lottos.size() + "개를 구매했습니다." +
                System.lineSeparator() +
                lottos.stream()
                        .map(lotto -> "[" + getLottoNumber(lotto) + "]")
                        .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(sb);
    }

    private String getLottoNumber(Lotto lotto) {
        StringBuilder result = new StringBuilder();
        List<LottoNum> lottoNumbers = lotto.getLottoNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            result.append(lottoNumbers.get(i));
            result.append(addComma(i, lottoNumbers.size() - 1));
        }
        return result.toString();
    }

    private static String addComma(int index, int lastIndex) {
        if (index != lastIndex) {
            return ", ";
        }
        return "";
    }

    public void printLottoResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();

        List<LottoWinnerPrice> lottoWinnerPrice = LottoWinnerPrice.getLottoWinnerPrice();
        for (LottoWinnerPrice winnerPrice : lottoWinnerPrice) {
            sb.append(winnerPrice.getMatchedCount())
                    .append("개 일치 (")
                    .append(winnerPrice.getPrice())
                    .append(")- ")
                    .append(lottoResult.getWinnerCount(
                            winnerPrice.getMatchedCount()
                    ))
                    .append("개");
            sb.append(System.lineSeparator());
        }
        sb.append("총 수익률은 ")
                .append(lottoResult.getReturnRate())
                .append("입니다.");

        System.out.println(sb);
    }
}
