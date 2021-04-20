package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class ResultView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> printLotto(lotto));
    }

    private void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLottoNumbers().stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("[" + lottoNumbers+ "]");
    }
}
