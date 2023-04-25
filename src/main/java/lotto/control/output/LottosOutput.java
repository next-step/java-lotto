package lotto.control.output;

import lotto.model.Lotto;
import lotto.view.View;
import lotto.view.result.LottosView;

import java.util.List;

public class LottosOutput implements Printable {

    private final List<Lotto> lottos;

    public LottosOutput(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void print() {
        View view = new LottosView(lottos);
        view.render();
    }
}
