package net.chandol.lotto.domain;

import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.Money;
import net.chandol.lotto.value.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;
import static net.chandol.lotto.domain.Lotto.LOTTO_PRICE;

public class LottoGame {
    private Money totalPrice;
    private Money availablePrice;
    private List<Lotto> lottos;

    public LottoGame(Money totalPrice) {
        this.totalPrice = totalPrice;
        this.availablePrice = totalPrice;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> purchase(List<LottoNumber> lottoNumbers) {
        isPurchaseAvailable(lottoNumbers);

        Money purchasePrice = LOTTO_PRICE.multiply(lottoNumbers.size());
        this.availablePrice = this.availablePrice.subtract(purchasePrice);

        List<Lotto> purchasedLottos = createLottos(lottoNumbers);
        lottos.addAll(purchasedLottos);

        return purchasedLottos;
    }

    private void isPurchaseAvailable(List<LottoNumber> lottoNumbers) {
        if (isNull(lottoNumbers)) {
            throw new IllegalArgumentException("입력값은 null이 될 수 없습니다.");
        }

        Money purchasePrice = LOTTO_PRICE.multiply(lottoNumbers.size());
        if (purchasePrice.compareTo(availablePrice) > 0) {
            throw new IllegalArgumentException("가용 금액이 부족합니다.");
        }
    }

    private static List<Lotto> createLottos(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(toList());
    }

    public List<Lotto> getLottos() {
        return unmodifiableList(lottos);
    }

    public int getAvailableLottoPurchaseCount() {
        return availablePrice.divideAsNumber(LOTTO_PRICE);
    }

    public LottoGameResult getLottoGameResult(WinningNumber winningNumber) {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winningNumber);
        return calculator.lottoGameResult(lottos);
    }

    public static List<LottoNumber> getAutoLottoNumbers(int size) {
        return generate(LottoNumber::auto)
                .limit(size).collect(Collectors.toList());
    }
}
