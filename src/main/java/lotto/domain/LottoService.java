package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoService {

    public static final int UPPER_LOTTO_NUMBER = 45;
    public static final int LOWER_LOTTO_NUMBER = 1;
    public static final int LOTTO_COUNT = 6;
    public static final int FROM_INDEX = 0;

    private final Payment payment;
    private final Lottos lottos;

    public LottoService(int value) {
        this.payment = new Payment(value);
        this.lottos = generateLottos();
    }

    private Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payment.getLottoCount(); i++) {
            lottos.add(new Lotto(generateLotto()));
        }

        return new Lottos(lottos);
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

    public int getCount() {
        return payment.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public ResultRecord getResult(final List<Integer> winningLotto, final int bonusBall) {
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);
        return new ResultRecord(lottos, winningNumber);
    }

    public ProfitRate getProfitRage(final int profit) {
        return new ProfitRate(profit, payment.getMoney());
    }
}
