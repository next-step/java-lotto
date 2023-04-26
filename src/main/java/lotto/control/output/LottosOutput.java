package lotto.control.output;

import lotto.model.dto.LottoDto;
import lotto.view.View;
import lotto.view.result.LottosView;

import java.util.List;

public class LottosOutput implements Printable {

    private final List<LottoDto> lottos;

    public LottosOutput(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void print() {
        View view = new LottosView(lottos);
        view.render();
    }
}
