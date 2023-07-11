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
        List<Integer> list = IntStream.range(1, 45 + 1)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(list);
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(list.subList(0, 6)));
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
            profit = resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return String.format("%.2f", profit / payment.getMoney());
    }
}
