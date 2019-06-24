package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public static LottoTicket buy(Money money) {
        long count = money.countAvailableLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return LottoTicket.of(lottos);
    }

    public static Lotto getWinningLotto(List<Integer> inputNumbers) {
        List<Number> numbers = inputNumbers.stream()
                .map(Number::of)
                .collect(Collectors.toList());
        return LottoGenerator.generate(numbers);
    }

    public static WinningLotto getWinningLotto(WinningLottoRequest winningLottoRequest) {
        Lotto lotto = LottoGenerator.generate(winningLottoRequest.getNumbers());
        return WinningLotto.generate(lotto, winningLottoRequest.getBonus());
    }
}
