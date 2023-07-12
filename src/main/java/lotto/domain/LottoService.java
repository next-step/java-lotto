package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoService {

    public static final int UPPER_LOTTO_NUMBER = 45;
    public static final int LOWER_LOTTO_NUMBER = 1;
    public static final int LOWER_LOTTO_COUNT = 0;
    public static final int UPPER_LOTTO_COUNT = 6;
    private final Payment payment;
    private final Lottos lottos;
    private final LottoResult lottoResult = new LottoResult();

    public LottoService(final String value) {
        this.payment = new Payment(value);
        this.lottos = generateLottos();
    }

    private Lottos generateLottos() {
        int count = payment.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers = IntStream.range(LOWER_LOTTO_NUMBER, UPPER_LOTTO_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLotto(numbers)));
        }
        return new Lottos(lottos);
    }

    private List<Integer> generateLotto(final List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers.subList(LOWER_LOTTO_COUNT, UPPER_LOTTO_COUNT);
    }

    public int getCount() {
        return payment.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Map<LottoMatch, Integer> getResult(final String winningLotto, final String bonusBall) {
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);
        lottoResult.recordResult(lottos, winningNumber);
        return lottoResult.getResult();
    }

    public String getProfitRate() {
        return String.format("%.2f", lottoResult.getProfit() / payment.getMoney());
    }
}
