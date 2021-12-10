package lotto;

import java.util.*;

public class Lottos {

    private static final Money LOTTO_PRICE = new Money(1000);
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static final List<Integer> lottoNumberSource = new ArrayList<Integer>() {{
        addAll(Arrays.asList(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,41,42,43,44,45
        ));
    }};

    private final LottoResult lottoResult;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottoResult = new LottoResult();
    }

    public static Lottos buy(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        long countCanBuy = money.countCanBuy(LOTTO_PRICE);

        for(int i = 0; i < countCanBuy; i++) {
            List<Number> numbers = createLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    private static List<Number> createLottoNumbers() {
        List<Number> lottoNumbers = new ArrayList<>();
        Collections.shuffle(lottoNumberSource);

        for(int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            lottoNumbers.add(new Number(lottoNumberSource.get(i)));
        }

        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void updateLottoResult(Lotto winnerLotto) {
        for(Lotto lotto : lottos) {
            lottoResult.updateMatchCount(lotto, winnerLotto);
        }

        lottoResult.updateProfit(count(), LOTTO_PRICE);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public String lottoToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
