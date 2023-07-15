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

    public List<LottoTicketDto> purchase(long money, List<LottoTicketDto> lottoTicketDtos) {
        assertMoney(money);
        assertPassiveLottoTickets(money, lottoTicketDtos);
        money -= (long) lottoTicketDtos.size() * LottoTicket.PURCHASABLE_UNIT;
        List<LottoTicket> lottoTickets = lottoTicketDtos.stream()
            .map(lottoTicketDto -> new LottoTicket(lottoTicketDto.getNumbers()))
            .collect(Collectors.toList());
        lottoTickets.addAll(createLottoTickets(money));
        return toLottoTicketDtos(lottoTickets);
    }

    private void assertMoney(long money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT,
                    money));
        }
    }

    private void assertPassiveLottoTickets(long money, List<LottoTicketDto> lottoTicketDtos) {
        long lottoBuyableCount = money / LottoTicket.PURCHASABLE_UNIT;
        if (lottoBuyableCount < lottoTicketDtos.size()) {
            throw new IllegalArgumentException(String.format("구매가능한 로또 숫자 \"%d\" 보다 선택한 로또의 숫자가 더 많습니다.",
                lottoBuyableCount));
        }
    }

    private List<LottoTicket> createLottoTickets(long money) {
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
