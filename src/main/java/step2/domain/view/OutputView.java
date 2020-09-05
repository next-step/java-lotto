package step2.domain.view;

import step2.domain.*;

import java.util.stream.Collectors;

public class OutputView {

    public void viewLottoNumbers(Lottos lottos) {
        System.out.println(lottos.getLottoList().size() + "개를 구매했습니다.");
        lottos.getLottoList()
                .stream()
                .map(Lotto::toIntegerList)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void viewResult(LottoResult lottoResult, String lottoMoney) {

        LottoRank.getLottoMatchingList().stream()
                .filter(count -> count.getCount() > 0)
                .map(rank -> makeRankResultString(rank, lottoResult))
                .forEach(System.out::println);
        double winningRate = lottoResult.calculateWinningRate(lottoMoney);
        System.out.format("총 수익률은 %.2f 입니다.", winningRate);

    }

    private static String makeRankResultString(LottoRank matchingCount, LottoResult lottoResult) {
        String message = "%d개 일치 (%d원) - %d개";
        if(matchingCount.equals(matchingCount.SECOND_BONUS)) {
            message = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
        }

        return String.format(message,
                matchingCount.getCount(),
                matchingCount.getMoney(),
                lottoResult.getRankCount(matchingCount));
    }

}
