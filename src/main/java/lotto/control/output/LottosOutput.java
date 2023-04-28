package lotto.control.output;

import lotto.model.dto.LottosDto;
import lotto.view.View;
import lotto.view.result.LottosView;

public class LottosOutput implements Printable {
    private final LottosDto manuals;
    private final LottosDto autos;

    public LottosOutput(LottosDto manuals, LottosDto autos) {
        this.manuals = manuals;
        this.autos = autos;
    }

    @Override
    public void print() {
        View view = new LottosView(manuals, autos);
        view.render();
    }
}
