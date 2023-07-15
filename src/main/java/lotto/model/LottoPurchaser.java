package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPurchaser {

    private static final int ONE = 1;
    private final LottoMoney currentMoney;
    private final List<Lotto> purchasedLottos;

    public LottoPurchaser(final LottoMoney lottoMoney) {
        this.currentMoney = lottoMoney;
        this.purchasedLottos = new ArrayList<>();
    }

    public LottoPurchaser(final LottoMoney lottoMoney, final List<Lotto> lottos) {
        this.currentMoney = lottoMoney;
        this.purchasedLottos = lottos;
    }

    public LottoPurchaser buyAutoTicket() {
        LottoMoney afterMoney = this.currentMoney;
        List<Lotto> newLotto = new ArrayList<>(this.purchasedLottos);
        while (afterMoney.isPositive()) {
            newLotto.add(new Lotto(new AutoLottoGenerator().generate()));
            afterMoney = afterMoney.subtractByLottoCount(new Count(ONE));
        }
        return new LottoPurchaser(afterMoney, newLotto);
    }

    public LottoPurchaser buyFixTicket(final Count manualCount,
        final List<List<Integer>> manualLotto) {
        validateLottoCount(manualCount, manualLotto);
        List<Lotto> newLotto = new ArrayList<>(this.purchasedLottos);
        for (List<Integer> lotto : manualLotto) {
            newLotto.add(new Lotto(new FixLottoGenerator(convertLottoNumber(lotto)).generate()));
        }
        return new LottoPurchaser(currentMoney.subtractByLottoCount(manualCount), newLotto);
    }

    public LottoPurchaser purchaseLotto(final Count manualCount,
        final List<List<Integer>> manualLotto) {
        return buyFixTicket(manualCount, manualLotto).buyAutoTicket();
    }

    private List<LottoNumber> convertLottoNumber(final List<Integer> lottos) {
        return lottos.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }


    private void validateLottoCount(final Count manualCount,
        final List<List<Integer>> manualLotto) {
        if (manualCount.getCount() != manualLotto.size()) {
            throw new IllegalArgumentException("로또 구입 수와 로또 번호 입력 수가 일치하지 않습니다");
        }
        if (manualCount.getCount() > currentMoney.getLottoCount()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 현재 가지고 있는 돈보다 많습니다.");
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return new ArrayList<>(this.purchasedLottos);
    }

    public LottoMoney getCurrentLottoMoney() {
        return this.currentMoney;
    }
}
