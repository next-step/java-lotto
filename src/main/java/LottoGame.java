import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final int PRICE = 1000;

    public Lottos buy(int budget) {
        int buyCount = countBuyLotto(budget);

        List<Lotto> lottoList = IntStream.range(0, buyCount)
                .boxed()
                .map(i -> new Lotto())
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    public WinningResults draw(Lottos lottos, LottoNumbers winningNumbers) {
        return LottoDraw.draw(lottos, winningNumbers);
    }

    private int countBuyLotto(int budget) {
        return budget / PRICE;
    }
}
