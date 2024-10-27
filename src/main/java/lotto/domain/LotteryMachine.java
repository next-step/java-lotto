package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.util.LottoAutoGenerator;

public class LotteryMachine {

    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public LotteryMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LotteryMachine createWithManualLottos(final List<String> manualLottoNumbers, final int purchaseAmount) {
        final int remainingAmount = purchaseAmount - (manualLottoNumbers.size() * LOTTO_PRICE);
        List<Lotto> manualLottos = createManualLottos(manualLottoNumbers);
        List<Lotto> autoLottos = purchaseLottos(remainingAmount);
        List<Lotto> combinedLottos = combineLottos(manualLottos, autoLottos);
        return new LotteryMachine(combinedLottos);
    }

    private static void validatePrice(final int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0보다 작은 값일 수 없습니다.");
        }
    }

    private static List<Lotto> purchaseLottos(final int purchasePrice) {
        validatePrice(purchasePrice);
        return LottoAutoGenerator.generate(purchasePrice / LOTTO_PRICE);
    }

    private static List<Lotto> createManualLottos(final List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static List<Lotto> combineLottos(final List<Lotto> manualLottos,
            final List<Lotto> autoLottos) {
        List<Lotto> combinedLottos = new ArrayList<>(manualLottos);
        combinedLottos.addAll(autoLottos);
        return combinedLottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getPurchasedLottoCount() {
        return lottos.size();
    }

    public int getTotalPurchasePrice() {
        return lottos.size() * LOTTO_PRICE;
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumberInfo)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LotteryMachine that = (LotteryMachine) o;

        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return lottos != null ? lottos.hashCode() : 0;
    }
}
