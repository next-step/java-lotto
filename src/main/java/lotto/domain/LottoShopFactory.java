package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoShopFactory {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();
    private final List<List<String>> manuallyLotto;

    public LottoShopFactory(List<List<String>> manuallyLotto) {
        this.manuallyLotto = manuallyLotto;
    }

    public static LottoShopFactory of(List<List<String>> manuallyLotto) {
        return new LottoShopFactory(manuallyLotto);
    }

    public List<Lotto> createLottos(MoneyWallet moneyWallet) {

        List<Lotto> manuallyPurchase = manuallyPurchase(moneyWallet);
        int money = LOTTO_PRICE * manuallyLotto.size();
        moneyWallet = moneyWallet.withdraw(money);

        List<Lotto> autoPurchase = autoPurchase(moneyWallet);

        if (!manuallyPurchase.isEmpty()) {
            return Stream.concat(manuallyPurchase.stream(), autoPurchase.stream())
                .collect(Collectors.toList());
        }
        return autoPurchase;
    }

    private List<Lotto> manuallyPurchase(MoneyWallet moneyWallet) {
        return createManuallyLottoList();
    }

    private List<Lotto> createManuallyLottoList() {
        return this.manuallyLotto.stream()
            .map(list -> Lotto.manually(list.stream()
                .map(s -> LottoNumber.from(Integer.parseInt(s)))
                .collect(Collectors.toList())))
            .collect(Collectors.toList());
    }

    private List<Lotto> autoPurchase(MoneyWallet moneyWallet) {
        List<Lotto> lottoList = createAutoLottoListWithMoney(moneyWallet.balance());
        moneyWallet = moneyWallet.withdraw(manuallyLottoCount() * LOTTO_PRICE);
        return lottoList;
    }

    private static List<Lotto> createAutoLottoListWithMoney(int money) {
        return IntStream.range(0, countOfLottoAvailablePurchase(money))
            .mapToObj(i -> Lotto.auto(lottoNumberFactory.createLottoNumbers()))
            .collect(Collectors.toList());
    }

    private static int countOfLottoAvailablePurchase(int money) {
        return money / LOTTO_PRICE;
    }

    public int manuallyLottoCount(){
        return this.manuallyLotto.size();
    }


}
