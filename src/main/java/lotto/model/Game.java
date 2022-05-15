package lotto.model;

import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Game {
    private static final String BUY_MESSAGE_BY_AUTO = "%s개를 구매했습니다.";
    private static final String BUY_MESSAGE_BY_MANUAL = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private final List<Lotto> lottoList;

    private Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    private static Number getBuyingCount(Number price) {
        return price.divide(Number.of(1000L));
    }

    public static Game pay(Number price) {
        long count = getBuyingCount(price).longValue();
        ResultView.print(String.format(BUY_MESSAGE_BY_AUTO, count));

        List<Lotto> lottoList = LongStream
                .range(0L, count)
                .mapToObj(i -> Lotto.auto())
                .peek(ResultView::print)
                .collect(Collectors.toList());

        return new Game(lottoList);
    }

    public static Game pay(Number price, List<Lotto> lottoList) {
        long count = getBuyingCount(price).longValue();
        ResultView.print();
        ResultView.print(String.format(BUY_MESSAGE_BY_MANUAL, count, lottoList.size()));

        LongStream
                .range(lottoList.size(), count)
                .forEach(i -> lottoList.add(Lotto.auto()));
        lottoList.forEach(ResultView::print);

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
