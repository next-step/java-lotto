package lotto.domain;

import java.util.*;

import static java.util.Collections.*;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this(createLottos(amount));
    }

    // 주생성자
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getQuantity() {
        return lottos.size();
    }

    public List<List<LottoNumber>> getLottoNumbers() {
        List<List<LottoNumber>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getLottoNumbers());
        }
        return unmodifiableList(lottoNumbers);
    }

    public LottoResult getLottoResult(Lotto lastWinningLotto) {
        return new LottoResult(createLottoResult(lastWinningLotto));
    }

    public double calculateProfitability(LottoResult lottoResult, double amount) {
        Map<LottoRank, Integer> resultMap = lottoResult.getResultMap();
        int profit = 0;
        for (Map.Entry<LottoRank, Integer> entry : resultMap.entrySet()) {
            LottoRank lottoRank = entry.getKey();
            Integer integer = entry.getValue();
            profit += lottoRank.getWinningPrize() * integer;
        }
        return profit / amount;
    }

    private static List<Lotto> createLottos(int amount) {
        int quantity = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumbers.add(i);
        }
        shuffle(randomNumbers);
        return randomNumbers.subList(ZERO, LOTTO_SIZE);
    }

    private Map<LottoRank, Integer> createLottoResult(Lotto lastWinningLotto) {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.determineRank(lastWinningLotto);
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0) + 1);
        }
        resultMap.remove(LottoRank.ETC);
        return resultMap;
    }
}
