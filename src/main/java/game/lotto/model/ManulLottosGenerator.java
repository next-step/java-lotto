package game.lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ManulLottosGenerator implements LottosGenerator {

    private final List<String> manualNumbers;

    public ManulLottosGenerator(List<String> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> manualLottos = manualNumbers.stream()
                .map(LottoNumberFactory::createLottoNumbers)
                .map(Lotto::manual)
                .collect(Collectors.toList());

        return manualLottos;
    }
}
