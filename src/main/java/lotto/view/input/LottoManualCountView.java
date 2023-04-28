package lotto.view.input;

import lotto.view.View;

public class LottoManualCountView implements View {
    @Override
    public void render() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }
}
