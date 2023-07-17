package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGame {

    static final int LOTTO_PRICE = 1_000;
    public static final int UPPER_LOTTO_NUMBER = 45;
    public static final int LOWER_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int FROM_INDEX = 0;
    private final Payment payment;
    private final Lottos lottos;
    private final LottoCount lottoCount;

    public LottoGame(final int paymentValue, final List<Lotto> manualLottos) {
        this.payment = new Payment(paymentValue);

        int randomCount = payment.calculateLottoCount() - manualLottos.size();
        this.lottoCount = new LottoCount(manualLottos.size(), randomCount);

        this.lottos = new Lottos(manualLottos, generateRandomLottos(randomCount));
    }

    private List<Lotto> generateRandomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomLotto()));
        }

        return lottos;
    }

    private List<Integer> generateRandomLotto() {
        List<Integer> numbers = generateNumbers();
        Collections.shuffle(numbers);

        return numbers.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOWER_LOTTO_NUMBER, UPPER_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        return numbers;
    }

    public int getManualCount() {
        return lottoCount.getManualCount();
    }

    public int getRandomCount() {
        return lottoCount.getRandomCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoResult getResult(final List<Integer> winningLotto, final int bonusBall) {
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);
        return new LottoResult(lottos, winningNumber);
    }

    public float getProfitRate(final LottoResult resultRecord) {
        return payment.calculateProfitRate(resultRecord.calculateProfit());
    }
}
