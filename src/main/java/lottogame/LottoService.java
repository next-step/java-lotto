package lottogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoService {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PICK_COUNT = 6;
    private final Payment payment;
    private final Lottos lottos;
    private LottoStatistics lottoStatistics;

    public LottoService(Payment payment) {
        this.payment = payment;
        this.lottos = generateLottos();
    }

    private Lottos generateLottos() {
        int count = payment.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoPossibleNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoPossibleNumbers);
            lottos.add(new Lotto(lottoPossibleNumbers.subList(0, LOTTO_PICK_COUNT)));
        }
        return new Lottos(lottos);
    }

    public Map<LottoMatch, Integer> getResult(WinningNumber winningNumber) {
        lottoStatistics = new LottoStatistics(lottos, winningNumber);
        return lottoStatistics.getStatistics();
    }

    public String getProfitRate(Payment payment) {
        return lottoStatistics.getProfitRate(payment);
    }

    public int getCount() {
        return payment.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }
}
