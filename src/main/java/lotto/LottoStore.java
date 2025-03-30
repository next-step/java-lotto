package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStore {
    public static final Integer LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static List<LottoNumbers> sellLotto(final int price) {
        LottoMachine lottoMachine = new LottoMachine(LottoNumbersCondition.getDefaultInstance());
        int lottoCount = price / LOTTO_PRICE;

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumber = lottoMachine.generateLottoNumber();
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }

    public static long receiveWinnings(Map<LottoRank, Integer> rankCount) {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> (long)entry.getKey().getMoney() * entry.getValue())
                .sum();
    }
}
