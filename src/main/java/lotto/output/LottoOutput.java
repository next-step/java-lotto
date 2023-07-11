package lotto.output;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

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

    private void printLotto(final Lotto lotto) {
        String formattedLotto = lotto.getLottoNumbers()
            .stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + formattedLotto + "]");
    }
}
