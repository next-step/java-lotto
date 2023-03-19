package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    public static final Money LOTTO_PRICE = new Money(1000);

    private final List<Lotto> automaticLottos;
    private final List<Lotto> manualLottos;

    public LottoGame(List<Lotto> automaticLottos) {
        this(automaticLottos, List.of());
    }

    public LottoGame(Money lottoPay) {
        this(lottoPay, List.of());
    }

    public LottoGame(List<Lotto> automaticLottos, List<Lotto> manualLottos) {
        this.automaticLottos = automaticLottos;
        this.manualLottos = manualLottos;
    }

    public LottoGame(Money lottoPay, List<Set<Integer>> manualLottos) {
        int allLottoQuantity = lottoPay.division(LOTTO_PRICE).toInteger();
        int automaticIssueQuantity = allLottoQuantity - manualLottos.size();

        Money manualLottosPrice = LOTTO_PRICE.multiply(manualLottos.size());
        if (lottoPay.minus(manualLottosPrice).toInteger() < 0) {
            throw new IllegalArgumentException("사용한 금액보다 많은 로또를 발급할 수 없습니다.");
        }

        this.automaticLottos = new ArrayList<>();
        for (int i = 0; i < automaticIssueQuantity; i++) {
            this.automaticLottos.add(new Lotto(RandomNumberFactory.get()));
        }
        this.manualLottos = manualLottos.stream().map(lotto -> new Lotto(lotto.stream().mapToInt(i -> i).toArray())).collect(Collectors.toList());;
    }

    public List<Lotto> getAllManualLottos() {
        return this.manualLottos;
    }

    public List<Lotto> getAllAutomaticLottos() {
        return this.automaticLottos;
    }

    public WinningStatistics getStatistics(WinningNumbers winningNumbers) {
        return new WinningStatistics(winningNumbers, getAllLottos());
    }

    private List<Lotto> getAllLottos() {
        return Stream.concat(manualLottos.stream(), automaticLottos.stream()).collect(Collectors.toList());
    }

    public Money getBuyPrice() {
        return LOTTO_PRICE.multiply(getAllLottos().size());
    }
}
