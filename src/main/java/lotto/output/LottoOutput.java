package lotto.output;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;

public class LottoOutput {

    public void printAskPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printAmount(final int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printAskWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printAskBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printLottos(final List<Lotto> lottos) {
        lottos.forEach(this::printLotto);
    }

    public void printStatistics(final Map<LottoRank, Long> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        statistics.keySet()
            .forEach(key -> System.out.println(getResultString(key, statistics.get(key))));
    }

    private String getResultString(final LottoRank key, Long count) {
        if (key == LottoRank.SECOND) {
            return key.getMatch() + "개 일치, 보너스 볼 일치(" + key.getPrize() + "원)- " + count + "개";
        }
        return key.getMatch() + "개 일치 (" + key.getPrize() + "원)- " + count + "개";
    }

    public void printYield(final Double yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }

    private void printLotto(final Lotto lotto) {
        String formattedLotto = lotto.getLottoNumbers()
            .stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + formattedLotto + "]");
    }
}
