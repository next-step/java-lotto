package lotto.domain;

import lotto.dto.LottoInput;
import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Wallet {

    private final Lottos lottos;
    private final Money originMoney;
    private Money myMoney;

    private Wallet(Money money, Money originMoney, Lottos lottos) {
        this.myMoney = money;
        this.originMoney = originMoney;
        this.lottos = lottos;
    }

    public static Wallet create(Money money, Lottos lottos) {
        return new Wallet(money, money, lottos);
    }

    public static Wallet create(Money money, Money originMoney, Lottos lottos) {
        return new Wallet(money, originMoney, lottos);
    }

    public static Wallet create(Money money) {
        return new Wallet(money, money, Lottos.create(Collections.EMPTY_LIST));
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinningHistory getWinningHistory(Lotto winningLotto, LottoNumber bonus) {
        List<WinningRank> winningRanks = findWinningRanks(winningLotto, bonus);
        Money winningMoney = getWinningMoney(winningRanks);
        return WinningHistory.create(originMoney, winningRanks, winningMoney);
    }

    public Wallet buyLottos(LottoSeller lottoSeller, LottoInput lottoInput) {
        Lottos manualLottos = getManualLottoList(lottoSeller, lottoInput);
        Lottos autoLottos = getAutoLottos(lottoSeller);

        return Wallet.create(myMoney, originMoney, manualLottos.addLottos(autoLottos));
    }

    private List<WinningRank> findWinningRanks(Lotto winningLotto, LottoNumber bonus) {
        return WinningRank.findWinningRanks(lottos, winningLotto, bonus);
    }

    private Money getWinningMoney(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(BigDecimal.ZERO));
    }

    private Money getMoneyToBuy(Money price) {
        this.myMoney = this.myMoney.subtract(price);
        return price;
    }

    private Lottos getAutoLottos(LottoSeller lottoSeller) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        return lottoSeller.buyLottos(getAllMoney(), randomLottoGenerator);
    }

    private Lottos getManualLottoList(LottoSeller lottoSeller, LottoInput lottoInput) {
        List<String> manualLottoList = lottoInput.getManualLottoList();
        return manualLottoList.stream()
                .map(manual -> {
                    Money moneyToBuy = getMoneyToBuy(lottoSeller.getPrice());
                    return lottoSeller.buyLotto(moneyToBuy, new StringLottoGenerator(manual));
                }).collect(collectingAndThen(toList(), Lottos::create));
    }

    private Money getAllMoney() {
        Money money = Money.create(myMoney.getValue());
        myMoney = Money.ZERO;
        return money;
    }

}
