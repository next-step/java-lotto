package lotto.domain;

import lotto.ui.LottoRequest;
import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public LottoTickets buyLotto(final LottoRequest request) {
        int money = request.getMoney();
        int totalLottoCount = calculateLottoCount(money);
        LottoInput input = LottoInput.inputLottoCount();
        checkBuyableManualLotto(totalLottoCount, input);

        List<List<Integer>> inputManualLottoNumbers = input.inputLottoNumbers();
        LottoTickets lottoTickets = LottoTickets.createManualLottoTickets(inputManualLottoNumbers);
        int autoLottoCount = totalLottoCount - lottoTickets.size();

        if (autoLottoCount > 0) {
            LottoTickets autoLottoTickets = LottoTickets.of(autoLottoCount);
            lottoTickets.addLottoTickets(autoLottoTickets);
        }

        input.printTotalLottoCount(inputManualLottoNumbers.size(), autoLottoCount);
        lottoTickets.printLottoTickets();
        return lottoTickets;
    }

    private void checkBuyableManualLotto(int totalLottoCount, LottoInput input) {
        int manualLottoNumber = input.getNumberOfLotto();
        int remainingLottoCount = totalLottoCount - manualLottoNumber;

        if (remainingLottoCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 전체 구매가능한 로또 수를 초과하였습니다. manualNumber: " + manualLottoNumber);
        }
    }

    protected int calculateLottoCount(final int money) {
        checkMoney(money);
        return money / LOTTO_PRICE;
    }

    protected void checkMoney(int money) {
        if (money < LOTTO_PRICE) {
            String message = String.format("로또 가격은 %d원 입니다. 잔액이 부족 합니다. price: %d", LOTTO_PRICE, money);
            throw new IllegalArgumentException(message);
        }
    }
}
