package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_PRICE_INVALID = "구매 금액은 1000원 이상입니다.";
    private static final String LOTTO_MANUAL_COUNT_EXCEED = "구매 금액보다 입력받은 로또가 더 많습니다.";
    private final LottoNumberExtractor lottoNumberExtractor;

    public LottoMachine(LottoNumberExtractor lottoNumberExtractor) {
        this.lottoNumberExtractor = lottoNumberExtractor;
    }

    public LottoTickets makeLottoTickets(int price) {
        int count = price / LOTTO_PRICE;
        validateLottoTicketCount(count);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        addAutoLottoTickets(lottoTicketList, count);

        return new LottoTickets(lottoTicketList, price);
    }

    public LottoTickets makeLottoTickets(int price, List<List<Integer>> manualLottoTicketsNumbers) {
        int count = price / LOTTO_PRICE;
        int manualCount = manualLottoTicketsNumbers.size();

        validateLottoTicketCount(count);
        validateManualLottoTickets(count, manualCount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        manualLottoTicketsNumbers.forEach(numbers -> lottoTicketList.add(makeManualLottoTicket(numbers)));
        addAutoLottoTickets(lottoTicketList, count - manualCount);

        return new LottoTickets(lottoTicketList, price);
    }

    private void addAutoLottoTickets(List<LottoTicket> lottoTicketList, int autoCount) {
        for (int i = 0; i < autoCount; i++) {
            lottoTicketList.add(makeAutoLottoTicket());
        }
    }

    public LottoTicket makeAutoLottoTicket() {
        return new LottoTicket(lottoNumberExtractor.getNumbers(LottoTicket.LOTTO_SIZE));
    }

    public LottoTicket makeManualLottoTicket(List<Integer> manualLottoNumbers) {
        return LottoTicket.of(manualLottoNumbers);
    }

    public void validateLottoTicketCount(int totalLottoTicketCount) {
        if (totalLottoTicketCount < 1) {
            throw new IllegalArgumentException(LOTTO_PRICE_INVALID);
        }
    }

    public void validateManualLottoTickets(int totalLottoTicketCount, int manualLottoTicketCount) {
        if (totalLottoTicketCount < manualLottoTicketCount) {
            throw new IllegalArgumentException(LOTTO_MANUAL_COUNT_EXCEED);
        }
    }
}
