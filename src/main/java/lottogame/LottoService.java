package lottogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private final Payment payment;
    private final Lottos lottos;
    private Map<LottoMatch, Integer> resultMap;

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

    public int getCount() {
        return payment.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Map<LottoMatch, Integer> getResult(WinningNumber winningNumber) {
        resultMap = lottos.getResult(winningNumber);
        return resultMap;
    }

    public String getProfitRate() {
        float profit = 0;
        for (LottoMatch lottoMatch : resultMap.keySet()) {
            profit += resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return String.format("%.2f", profit / payment.getMoney());
    }
}
