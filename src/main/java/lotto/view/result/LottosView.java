package lotto.view.result;

import lotto.model.dto.LottoDto;
import lotto.view.View;

import java.util.List;

public class LottosView implements View {

    private final List<LottoDto> lottos;

    public LottosView(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void render() {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
