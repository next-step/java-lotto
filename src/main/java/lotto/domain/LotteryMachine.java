package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.util.LottoAutoGenerator;

public class LotteryMachine {

    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public LotteryMachine(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LotteryMachine(final int purchasePrice) {
        this(purchaseLotto(purchasePrice));
    }

    private static void valid(final int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0보다 작은 값일 수 없습니다.");
        }
    }

    private static List<Lotto> purchaseLotto(final int purchasePrice) {
        valid(purchasePrice);
        return LottoAutoGenerator.generate(purchasePrice / LOTTO_PRICE);
    }

    public LotteryMachine(final String purchasePrice) {
        this(Integer.parseInt(purchasePrice));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getPurchasedLottoCount() {
        return lottos.size();
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
