package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int DEFAULT_MANUAL_PURCHASE_COUNT = 0;
    private final int buyLottoPrice;
    private final List<LottoTicket> lottoTickets;

    private final int manualPurchaseCount;

    private WinningLottoTicket winningLottoNumber;

    private LottoStatistic lottoStatistic;

    public LottoMachine(int buyLottoPrice) {
        this(buyLottoPrice, DEFAULT_MANUAL_PURCHASE_COUNT, buyRandomLotto(buyLottoPrice));
    }

    public LottoMachine(int buyLottoPrice, List<String> manualPurchaseLottoNumbers, int manualPurchaseCount) {
        this(buyLottoPrice, manualPurchaseCount, initManualPurchaseTickets(buyLottoPrice, manualPurchaseCount, manualPurchaseLottoNumbers));
    }

    private static List<LottoTicket> initManualPurchaseTickets(int buyLottoPrice, int manualPurchaseCount, List<String> manualPurchaseLottoNumbers) {
        int buyAutoLottoPrice = buyLottoPrice - (LOTTO_PRICE * manualPurchaseCount);

        List<LottoTicket> autoLottoTickets = buyRandomLotto(buyAutoLottoPrice);

        if (manualPurchaseCount != manualPurchaseLottoNumbers.size()) {
            throw new IllegalArgumentException("수동 로또 갯수 에러");
        }

        List<LottoTicket> manualPurchaseTickets = manualPurchaseLottoNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        manualPurchaseTickets.addAll(autoLottoTickets);

        return manualPurchaseTickets;
    }


    public LottoMachine(int buyLottoPrice, List<LottoTicket> lottoTickets) {
        this(buyLottoPrice, DEFAULT_MANUAL_PURCHASE_COUNT, lottoTickets);
    }

    public LottoMachine(int buyLottoPrice, int manualPurchaseCount, List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.buyLottoPrice = buyLottoPrice;
        this.manualPurchaseCount = manualPurchaseCount;
        vaildLottoMachine(buyLottoPrice, lottoTickets);
    }

    public void vaildLottoMachine(int buyLottoPrice, List<LottoTicket> lottoTickets) {
        if (buyLottoPrice < LOTTO_PRICE
                || buyLottoPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액 에러");
        }

        if (lottoTickets.size() != buyLottoPrice / LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 갯수 에러");
        }
    }


    private static List<LottoTicket> buyRandomLotto(int buyLottoPrice) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < buyLottoPrice / LOTTO_PRICE; i++) {
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }

    public LottoStatistic initLottoStatistic(WinningLottoTicket winningLottoTicket) {
        this.winningLottoNumber = winningLottoTicket;
        this.lottoStatistic = new LottoStatistic(lottoTickets, winningLottoTicket, this.buyLottoPrice);

        return lottoStatistic;
    }

    public WinningLottoTicket getWinningLottoNumber() {
        return this.winningLottoNumber;
    }

    public int lottoTotalCount() {
        return lottoTickets.size();
    }

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
