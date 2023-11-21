package lotto.domain.lotto;

import lotto.constants.Winning;
import lotto.domain.lotto.strategy.GenerateStrategy;
import lotto.domain.summary.Summary;
import lotto.domain.summary.WinningSummary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    public static final int PRICE_PER_TICKET = 1000;

    private static final String PURCHASE_ERROR_MESSAGE = String.format("로또를 구매할 금액이 부족합니다. 로또 한장의 가격은 %s원 입니다.", PRICE_PER_TICKET);

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(long purchasePrice, GenerateStrategy strategy) {
        validatePurchasePrice(purchasePrice);
        long lottoCount = lottoCount(purchasePrice);

        List<Lotto> lottoList = Stream.generate(() -> Lotto.of(strategy.generate()))
                .limit(lottoCount)
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    private static void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < PRICE_PER_TICKET) {
            throw new IllegalArgumentException(String.format(PURCHASE_ERROR_MESSAGE, PRICE_PER_TICKET));
        }
    }

    private static long lottoCount(long purchasePrice) {
        return purchasePrice / PRICE_PER_TICKET;
    }

    public static Lottos of(long purchasePrice, List<Lotto> lottos) {
        validateLottoCount(purchasePrice, lottos.size());
        return of(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private static void validateLottoCount(long purchasePrice, long manualLottoCount) {
        if (purchasePrice < manualLottoCount * PRICE_PER_TICKET) {
            throw new IllegalArgumentException("지불금액 보다 수동 구매금액이 더 많습니다.");
        }
    }

    public static void validate(long purchasePrice, long manualLottoCount) {
        validatePurchasePrice(purchasePrice);
        validateLottoCount(purchasePrice, manualLottoCount);
    }

    public static Lottos concat(Lottos lottosA, Lottos lottosB) {
        List<Lotto> collect = Stream.concat(lottosA.lottos.stream(), lottosB.lottos.stream())
                .collect(Collectors.toList());
        return new Lottos(collect);
    }

    public Summary match(Lotto jackpot, LottoNumber bonusNumber) {
        WinningSummary winningSummary = new WinningSummary();

        WinningLotto winningLotto = WinningLotto.of(jackpot, bonusNumber);

        for (Lotto lotto : lottos) {
            Winning winning = winningLotto.match(lotto);
            winningSummary.addWinning(winning);
        }

        return new Summary(winningSummary, purchasePrice());
    }

    public long purchasePrice() {
        return (long) lottos.size() * PRICE_PER_TICKET;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
