package lotto.domain;

import lotto.ui.LottoBuyingRequest;

import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public LottoTicketList buyLotto(final LottoBuyingRequest request) {
        int buyingPrice = request.getBuyingPrice();
        int totalLottoCount = calculateLottoCount(buyingPrice);
        checkBuyableManualLotto(totalLottoCount, request);
        List<String> manualLottoNumbers = request.getManualLottoNumbers();
        LottoTicketList manualLottoTicketList = LottoTicketList.createManualLottoTicketList(manualLottoNumbers);
        checkBuyableAutoLottoTicket(totalLottoCount, manualLottoTicketList);
        return manualLottoTicketList;
    }

    private void checkBuyableAutoLottoTicket(int totalLottoCount, LottoTicketList manualLottoTicketList) {
        int numberOfAutoLottoTicket = totalLottoCount - manualLottoTicketList.size();

        if (numberOfAutoLottoTicket > 0) {
            LottoTicketList autoLottoTicketList = LottoTicketList.createAutoLottoTicketList(numberOfAutoLottoTicket);
            manualLottoTicketList.addLottoTicketList(autoLottoTicketList);
        }
    }

    private void checkBuyableManualLotto(int totalLottoCount, LottoBuyingRequest request) {
        int numberOfManualLotto = request.getNumberOfManualLotto();
        int remainingLottoCount = totalLottoCount - numberOfManualLotto;

        if (remainingLottoCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 전체 구매가능한 로또 수를 초과하였습니다. manualNumber: " + numberOfManualLotto);
        }
    }

    protected int calculateLottoCount(final int buyingPrice) {
        checkMoney(buyingPrice);
        return buyingPrice / LOTTO_PRICE;
    }

    protected void checkMoney(int money) {
        if (money < LOTTO_PRICE) {
            String message = String.format("로또 가격은 %d원 입니다. 잔액이 부족 합니다. price: %d", LOTTO_PRICE, money);
            throw new IllegalArgumentException(message);
        }
    }
}
