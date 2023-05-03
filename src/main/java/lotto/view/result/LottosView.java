package lotto.view.result;

import lotto.model.dto.LottosDto;
import lotto.view.View;

public class LottosView implements View {
    private final LottosDto manuals;
    private final LottosDto autos;


    public LottosView(LottosDto manuals, LottosDto autos) {
        this.manuals = manuals;
        this.autos = autos;
    }

    @Override
    public void render() {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manuals.size(), autos.size());
        System.out.println(manuals);
        System.out.println(autos);
    }
}
