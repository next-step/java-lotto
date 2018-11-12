package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.LottoGameResult;

public class ResultView {

    public static void showLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Integer number : lotto.getLottoNumbers()) {
            sb.append(number+", ");
        }
        String s = sb.substring(0, sb.lastIndexOf(",")) + " ]";
        System.out.println(s);
    }

    public static void showResult(LottoGameResult lottoGameResult) {
        StringBuilder sb = new StringBuilder();

        for (LottoDto lottoDto : lottoGameResult.getLottoDtos()) {
            sb.append(lottoDto.getWinnerCategory() + "개 일치 (" + lottoDto.getDefaultMoney() + "원)-" + lottoDto.getMatchNumber() + "개\n");
        }

        System.out.println(sb.toString());
    }

    public static void showRatioResult(String ratio) {
        System.out.println("총 수익률은 " + ratio + "입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
    }
}
