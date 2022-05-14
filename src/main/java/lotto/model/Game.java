package lotto.model;

import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final String BUY_MESSAGE = "%s개를 구매했습니다.";
    private final List<Lotto> lottoList;

    private Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Game pay(int price) {
        ResultView.print(String.format(BUY_MESSAGE, price));

        int count = price / 1000;
        List<Lotto> lottoList = IntStream
                .range(0, count)
                .mapToObj(i -> Lotto.auto())
                .peek(ResultView::print)
                .collect(Collectors.toList());

        return new Game(lottoList);
    }

    public Prize findWinners(Lotto beforeLotto, Number bonusNumber) {
        return Prize
                .init(beforeLotto, bonusNumber)
                .classify(this.getLottoList());
    }

    public Prize findWinners(Lotto beforeLotto) {
        return Prize
                .init(beforeLotto)
                .classify(this.getLottoList());
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
