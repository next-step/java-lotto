package lotto.view;

import lotto.Lotto;
import lotto.data.Lottos;

public class TerminalViewer implements Viewer {
    @Override
    public void view(Lottos lottos) {
        lottos.getLottos().forEach(Lotto::toString);
    }

    @Override
    public void viewResult(LottoResult result) {
        System.out.println("결과 확인");
        System.out.println(result.viewResult());
    }
}
