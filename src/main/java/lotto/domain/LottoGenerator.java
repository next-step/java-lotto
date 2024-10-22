package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;

    private int money;
    private int purchaseCount;

    public LottoGenerator(int money, int purchaseCount) {
        validateInputValue(money);
        this.money = money;
        this.purchaseCount = purchaseCount;
    }

    public LottoGenerator(int amount) {
        this(amount, 0);
    }

    private void validateInputValue(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한장의 금액은 1000원 입니다.");
        }
    }

    public List<Lotto> generatorLottos(List<String> manualLottos) {
        validateInputValue(manualLottos);
        List<Lotto> lottos = new ArrayList<>(extractLottosFromStrings(manualLottos));
        lottos.addAll(generateLottos(purchasableLottoCount()));
        return lottos;
    }

    private void validateInputValue(List<String> manualLottos) {
        int quantity = manualLottos.size();
        if (money < quantity * LOTTO_PRICE) {
            throw new IllegalArgumentException("현재 금액으로 수동 로또 " + quantity + "장을 살 수 없습니다.");
        }
        this.money -= quantity * LOTTO_PRICE;
        this.purchaseCount += quantity;
    }

    private List<Lotto> extractLottosFromStrings(List<String> lottosStr) {
        return lottosStr.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private int purchasableLottoCount() {
        return money / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int size) {
        this.purchaseCount += size;
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseCount * LOTTO_PRICE;
    }

    private static Lotto createLotto() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_VALUE; num <= LOTTO_MAX_VALUE; ++num) {
            numbers.add(LottoNumber.from(num));
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_SIZE);
        numbers.sort((Comparator.comparingInt(LottoNumber::getLottoNumber)));
        return new Lotto(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGenerator that = (LottoGenerator) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
