package game.lotto.model;

import java.util.List;

public class ComplexLottosGenerator implements LottosGenerator {

    private final AutoLottosGenerator auto;
    private final ManulLottosGenerator manual;

    public ComplexLottosGenerator(AutoLottosGenerator auto, ManulLottosGenerator manual) {
        this.auto = auto;
        this.manual = manual;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottos = manual.generate();
        lottos.addAll(auto.generate());
        return lottos;
    }
}
