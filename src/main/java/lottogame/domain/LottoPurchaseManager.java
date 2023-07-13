package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottogame.domain.response.LottoTicketResponse;
import lottogame.domain.spi.NumberGenerator;

public class LottoPurchaseManager {

    private final NumberGenerator numberGenerator;

    public LottoPurchaseManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<LottoTicketResponse> purchase(int money) {
        assertMoney(money);
        List<LottoTicket> lottoTicketRespons = createLottoNumbers(money);
        return toLottoTicketResponses(lottoTicketRespons);
    }

    private void assertMoney(int money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT,
                    money));
        }
    }

    private List<LottoTicket> createLottoNumbers(int money) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int count = 0; count < money / LottoTicket.PURCHASABLE_UNIT; count++) {
            lottoTicketList.add(new LottoTicket(numberGenerator));
        }
        return lottoTicketList;
    }

    private List<LottoTicketResponse> toLottoTicketResponses(
        List<LottoTicket> lottoTicketRespons) {
        return lottoTicketRespons.stream()
            .map(lottoTicket -> new lottogame.domain.response.LottoTicketResponse(lottoTicket.getValues()))
            .collect(Collectors.toList());
    }
}
