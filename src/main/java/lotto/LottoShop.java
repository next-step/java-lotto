package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;
    private static final LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();

    private final List<Lotto> assignedLottoList;

    public LottoShop(List<Lotto> assignedLottoList) {
        this.assignedLottoList = assignedLottoList;
    }

    public static LottoShop from(int money) {
        return new LottoShop(createLottoListWithMoney(money));
    }

    private static List<Lotto> createLottoListWithMoney(int money) {
        return IntStream.range(0, countOfLottoAvailablePurchase(money))
            .mapToObj(i -> createLottoTicket())
            .collect(Collectors.toList());
    }

    public List<Lotto> assignedLottoList() {
        return this.assignedLottoList;
    }

    private int totalPurchaseAmount() {
        return this.assignedLottoList.size() * LOTTO_PRICE;
    }

    private static int countOfLottoAvailablePurchase(int money) {
        return money / LOTTO_PRICE;
    }

    private static Lotto createLottoTicket() {
        return Lotto.from(lottoNumberFactory.number());
    }

    public LottoWallet purchase() {
        return new LottoWallet(this.assignedLottoList, totalPurchaseAmount());
    }
}
