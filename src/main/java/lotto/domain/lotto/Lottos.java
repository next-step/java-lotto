package lotto.domain.lotto;

import lotto.constants.Winning;
import lotto.domain.lotto.strategy.GenerateStrategy;
import lotto.dto.Summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private static final int PRICE_PER_TICKET = 1000;

    private static final String PURCHASE_ERROR_MESSAGE = String.format("로또를 구매할 금액이 부족합니다. 로또 한장의 가격은 %s원 입니다.", PRICE_PER_TICKET);

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(long purchasePrice, GenerateStrategy strategy) {
        long lottoCount = lottoCount(purchasePrice);

        List<Lotto> lottoList = Stream.generate(() -> Lotto.of(strategy.generate()))
                .limit(lottoCount)
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    private static long lottoCount(long purchasePrice) {
        long lottoCount = purchasePrice / PRICE_PER_TICKET;
        validateCount(lottoCount);
        return lottoCount;
    }

    private static void validateCount(long lottoCount) {
        if (noPurchase(lottoCount)) {
            throw new IllegalArgumentException(PURCHASE_ERROR_MESSAGE);
        }
    }

    public static Lottos of(List<List<Integer>> lottos) {
        List<Lotto> lottoList = lottos.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    private static boolean noPurchase(long lottoCount) {
        return lottoCount == 0;
    }

    public Summary match(Lotto jackpot, LottoNumber bonusNumber) {
        List<Winning> winnings = new ArrayList<>();

        WinningLotto winningLotto = WinningLotto.of(jackpot, bonusNumber);

        for (Lotto lotto : lottos) {
            Winning winning = winningLotto.match(lotto);
            winnings.add(winning);
        }

        return winningResult(winnings);
    }

    public Summary winningResult(List<Winning> winnings) {
        return new Summary(winnings, purchasePrice());
    }

    public long purchasePrice() {
        return lottos.size() * PRICE_PER_TICKET;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
