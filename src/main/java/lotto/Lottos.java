package lotto;

import java.util.*;

import static java.util.Collections.shuffle;

public class Lottos {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private final List<Lotto> lottos;

    private static final int LOTTO_PRICE = 1000;

    public Lottos(int amount) {
        throwIfInvalidAmount(amount);
        this.lottos = createLottos(calculateQuantity(amount));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int returnPurchaseQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }

    private static void throwIfInvalidAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상 입력해야 합니다.");
        }
    }

    private int calculateQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int lottoNumber = 1; lottoNumber <= 45; lottoNumber++) {
            randomNumbers.add(lottoNumber);
        }
        shuffle(randomNumbers);
        List<Integer> lottoNumbers = randomNumbers.subList(0, 6);
        lottoNumbers.sort(Integer::compareTo);
        return new ArrayList<>(lottoNumbers);
    }

    public LottoResults createLottoResults(Lotto lastWinningLotto) {
        Map<LottoRank, Integer> results = new HashMap<>();
        results.put(LottoRank.FIFTH, countMatchingNumbers(lastWinningLotto, LottoRank.FIFTH.getMatchingNumbers()));
        results.put(LottoRank.FOURTH, countMatchingNumbers(lastWinningLotto, LottoRank.FOURTH.getMatchingNumbers()));
        results.put(LottoRank.THIRD, countMatchingNumbers(lastWinningLotto, LottoRank.THIRD.getMatchingNumbers()));
        results.put(LottoRank.FIRST, countMatchingNumbers(lastWinningLotto, LottoRank.FIRST.getMatchingNumbers()));
        return new LottoResults(results);
    }

    private int countMatchingNumbers(Lotto lastWinningLotto, int findingNumber) {
        return (int) lottos.stream()
                .mapToInt(lotto -> lotto.countMatchingNumbers(lastWinningLotto))
                .filter(matchingNumbers -> matchingNumbers == findingNumber)
                .count();
    }


}
