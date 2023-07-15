package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGame {

    public static final int UPPER_LOTTO_NUMBER = 45;
    public static final int LOWER_LOTTO_NUMBER = 1;
    private static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_COUNT = 6;
    public static final int FROM_INDEX = 0;
    private final LottoPurchase lottoPurchase;
    private final Lottos lottos;

    public LottoGame(int paymentValue, int manualCountValue, List<Lotto> lottos) {
        this.lottoPurchase = new LottoPurchase(paymentValue, manualCountValue);
        lottos.addAll(generateLottos());
        this.lottos = new Lottos(lottos);
    }

    private List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchase.getAutomaticCount(); i++) {
            lottos.add(new Lotto(generateLotto()));
        }

        return lottos;
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = generateNumbers();
        Collections.shuffle(numbers);

        return numbers.subList(FROM_INDEX, LOTTO_COUNT);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOWER_LOTTO_NUMBER, UPPER_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        return numbers;
    }

    public int getManualCount() {
        return lottoPurchase.getManualCount();
    }

    public int getAutomaticCount() {
        return lottoPurchase.getAutomaticCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public ResultRecord getResult(final List<Integer> winningLotto, final int bonusBall) {
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);
        return new ResultRecord(lottos, winningNumber);
    }

    public ProfitRate getProfitRate(final ResultRecord resultRecord) {
        return new ProfitRate(resultRecord, lottoPurchase.getPayment());
    }
}
