package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.spi.NumberGenerator;

public class LottoPurchaseManager {

    private final NumberGenerator numberGenerator;

    public LottoPurchaseManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<LottoTicketDto> purchase(int money) {
        assertMoney(money);
        List<LottoTicket> lottoTickets = createLottoTickets(money);
        return toLottoTicketDtos(lottoTickets);
    }

    private void assertMoney(int money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT,
                    money));
        }
    }

    private List<LottoTicket> createLottoTickets(int money) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int count = 0; count < money / LottoTicket.PURCHASABLE_UNIT; count++) {
            lottoTicketList.add(new LottoTicket(numberGenerator));
        }
        return lottoTicketList;
    }

    private List<LottoTicketDto> toLottoTicketDtos(
        List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(lottoTicket -> new LottoTicketDto(lottoTicket.getValues()))
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoPurchaseManager)) {
            return false;
        }
        LottoPurchaseManager that = (LottoPurchaseManager) o;
        return Objects.equals(numberGenerator, that.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGenerator);
    }

    @Override
    public String toString() {
        return "LottoPurchaseManager{" +
            "numberGenerator=" + numberGenerator +
            '}';
    }
}
