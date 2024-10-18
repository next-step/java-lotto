package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.Rank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.enums.Rank.SECOND_RANK;
import static lotto.enums.Rank.getLottoWinnerPrice;

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

    public void priceLottoStatus(Lottos lottos, Lottos manualLottos) {
        String sb = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottos.getSize(), lottos.getSize()) +
                System.lineSeparator() +
                manualLottos.getLottos().stream()
                        .map(lotto -> "[" + getLottoNumber(lotto) + "]")
                        .collect(Collectors.joining(System.lineSeparator())) +
                System.lineSeparator() +
                lottos.getLottos().stream()
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

        List<Rank> ranks = getLottoWinnerPrice();
        for (Rank rank : ranks) {
            sb.append(rank.getMatchedCount())
                    .append("개 일치");
            sb.append(addSecondRank(rank));
            sb.append(String.format("(%d)-%d개", rank.getPrice(), lottoResult.getWinnerCount(rank)));
            sb.append(System.lineSeparator());
        }
        sb.append("총 수익률은 ")
                .append(lottoResult.getReturnRate())
                .append("입니다.");

        System.out.println(sb);
    }

    private String addSecondRank(Rank rank) {
        if (rank == SECOND_RANK) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
