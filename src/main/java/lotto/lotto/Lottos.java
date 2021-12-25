package lotto.lotto;

import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.LottoResults;
import lotto.result.Rank;
import lotto.result.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Lottos {
    public static final String EXCEEDED_MANUAL_LOTTOS_MESSAGE = "수동으로 구매한 로또 개수가 총 구입 개수를 초과했습니다.";
    public static final String NULL_OR_EMPTY_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 로또의 번호를 입력해주세요.";

    private static final int LOTTO_PRICE = 1000;
    public static final int START_VALUE = 0;

    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos of(int purchaseAmount, Lottos manualLottos) {
        int autoLottosPurchaseAmount = calculateRemainingPurchaseAmount(purchaseAmount, manualLottos);
        Lottos autoLottos = from(autoLottosPurchaseAmount);
        return manualLottos.add(autoLottos);
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public static Lottos from(String[] inputs) {
        if (isNullOrEmpty(inputs)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MANUAL_LOTTO_NUMBERS_MESSAGE);
        }

        List<Lotto> lottos = Arrays.stream(inputs)
                .map(Lotto::from)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lottos from(int purchaseAmount) {
        int quantity = purchaseAmount / LOTTO_PRICE;

        List<Lotto> lottos = IntStream.range(START_VALUE, quantity)
                .mapToObj(value -> {
                    LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
                    return Lotto.from(lottoNumbers);
                }).collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public LottoResults result(WinningNumbers winningNumbers, int purchaseAmount) {
        Map<Rank, Long> result = values.stream()
                .collect(groupingBy(winningNumbers::result, counting()));

        return LottoResults.from(result, purchaseAmount);
    }

    public List<Lotto> values() {
        return values;
    }

    public int quantity() {
        return values.size();
    }

    private static boolean isNullOrEmpty(String[] inputs) {
        return inputs == null || inputs.length == 0;
    }

    private static int calculateRemainingPurchaseAmount(int purchaseAmount, Lottos manualLottos) {
        int remainingPurchaseAmount = purchaseAmount - manualLottos.values.size() * LOTTO_PRICE;

        if (remainingPurchaseAmount < 0) {
            throw new IllegalArgumentException(EXCEEDED_MANUAL_LOTTOS_MESSAGE);
        }

        return remainingPurchaseAmount;
    }

    private Lottos add(Lottos manualLottos) {
        values.addAll(manualLottos.values);
        return new Lottos(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(values, lottos1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "values=" + values +
                '}';
    }
}
