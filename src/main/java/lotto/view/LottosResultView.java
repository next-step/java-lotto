package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottosResultView implements View {

    private final List<Lotto> lottos;

    public LottosResultView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void render() {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
