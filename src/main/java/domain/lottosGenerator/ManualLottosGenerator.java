package domain.lottosGenerator;

import domain.Lotto;
import domain.Money;

import java.util.ArrayList;
import java.util.List;

public class ManualLottosGenerator implements LottosGenerator {

    private final List<String> manualNumbers;

    public ManualLottosGenerator(List<String> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> games = new ArrayList<>();

        for (String manualNumber : manualNumbers) {
            games.add(Lotto.fromCommaString(manualNumber));
        }
        return games;
    }
}
