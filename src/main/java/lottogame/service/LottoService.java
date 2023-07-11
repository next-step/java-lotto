package lottogame.service;

import java.util.ArrayList;
import java.util.List;
import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;

public class LottoService {

    private static final int PURCHASABLE_UNIT = 1000;
    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<LottoTicket> purchase(int money) {
        assertMoney(money);
        return createLottoNumbers(money);
    }

    private void assertMoney(int money) {
        if (money % PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", PURCHASABLE_UNIT, money));
        }
    }

    private List<LottoTicket> createLottoNumbers(int money) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int count = 0; count < money % PURCHASABLE_UNIT; count++) {
            lottoTicketList.add(new LottoTicket(numberGenerator));
        }
        return lottoTicketList;
    }
}
