package lotto.domain;

import java.util.*;

public class UserLottos {
    private final List<Lotto> userLottos;
    private Quantity quantity;

    public UserLottos(String money) {
        this(new ArrayList<>(), new Money(money));
    }

    public UserLottos(int money) {
        this(new ArrayList<>(), new Money(money));
    }

    public UserLottos(List<Lotto> buyLottoNumbers, int money) {
        this(buyLottoNumbers, new Money(money));
    }

    public UserLottos(List<Lotto> buyLottoNumbers, Money money) {
        this.userLottos = buyLottoNumbers;
        this.quantity = new Quantity(money.getQuantity(), userLottos.size());
    }

    public void autoCreate() {
        this.userLottos.add(LottoFactory.createAutoLotto());
        this.quantity = this.quantity.increase();
    }

    public LottoResults getWinningResults(WinningLotto winningLottoNumber) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : userLottos) {
            results.add(lotto.getRank(winningLottoNumber));
        }
        return results;
    }

    public Money getWinningMoney(WinningLotto winningLotto) {
        Money moneySum = new Money();
        for (Lotto lotto : userLottos) {
            moneySum = lotto.getRank(winningLotto).sumWinningMoney(moneySum);
        }
        return moneySum;
    }

    public List<Lotto> getUserLottos() {
        return Collections.unmodifiableList(userLottos);
    }

    public int getSize() {
        return userLottos.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.userLottos.contains(lottoNumber);
    }

    public boolean isPurchasable() {
        return quantity.isPurchasable();
    }

    public int getMaxPurchasableQuantity() {
        return quantity.getMaxPurchasableQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLottos that = (UserLottos) o;
        return Objects.equals(userLottos, that.userLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottos);
    }

    @Override
    public String toString() {
        StringBuilder lottoNumbers = new StringBuilder();
        for (Lotto lottoNumber : this.userLottos) {
            lottoNumbers.append(lottoNumber.toString()).append("\n");
        }
        return lottoNumbers.toString();
    }

}
