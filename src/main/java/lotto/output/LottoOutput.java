package lotto.output;

import lotto.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoOutput {
    public void printAskPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printQuantity(final LottoQuantity manualQuantity, final LottoQuantity autoQuantity) {
        System.out.println("수동으로 "
                + manualQuantity.getQuantity()
                + "장, 자동으로 "
                + autoQuantity.getQuantity()
                + "개를 구매했습니다.");
    }

    public void printAskWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printAskBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printLottos(final LottoGroup lottoGroup) {
        lottoGroup.getLottos()
                .forEach(this::printLotto);
    }

    public void printStatistics(final LottoResult statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(LottoRank.NONE))
                .forEach(key -> System.out.println(getResultString(key, statistics.getResult().getOrDefault(key, 0L))));
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

    public void printYield(final Double yield) {
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private void printLotto(final Lotto lotto) {
        String formattedLotto = lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("[" + formattedLotto + "]");
    }

    public void printSectionDivider() {
        System.out.println();
    }

    public void printAskManualQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printAskManualLottonumbers() {
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
    }
}
