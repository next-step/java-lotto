package lotto.output;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class LottoOutput {

    public static final String LOTTO_JOIN_DELIMITER = ", ";

    public void printQuantity(final int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottos(final LottoGroup lottoGroup) {
        lottoGroup.getLottos()
            .forEach(this::printLotto);
        System.out.println();
    }

    public void printStatistics(final LottoResult statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRank.values())
            .filter(rank -> !rank.equals(LottoRank.NONE))
            .forEach(key -> System.out.println(
                getResultString(key, statistics.getResult().getOrDefault(key, 0L))));
    }

    private String getResultString(final LottoRank key, Long count) {
        StringBuilder builder = new StringBuilder();
        builder.append(key.getMatch()).append("개 일치");
        if (key == LottoRank.SECOND) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append("(").append(key.getPrize()).append("원)- ")
            .append(count).append("개");
        return builder.toString();
    }

    public void printProfit(final Double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "입니다.");
    }

    private void printLotto(final Lotto lotto) {
        String formattedLotto = lotto.getLottoNumbers()
            .stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_JOIN_DELIMITER));

        System.out.println("[" + formattedLotto + "]");
    }
}
