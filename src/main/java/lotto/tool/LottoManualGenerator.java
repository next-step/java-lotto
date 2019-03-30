package lotto.tool;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoManualGenerator implements LottoGenerator {

    private static final int LOTTO_MANUAL_DEFAULT_COUNT = 0;
    private final List<String[]> manualLottoNumbers;

    public LottoManualGenerator(List<String[]> manualInputs, LottoMoney lottoMoney) {
        checkManualTicketCount(lottoMoney.buy(), manualInputs.size());
        this.manualLottoNumbers = manualInputs;
    }

    private boolean checkManualTicketCount(int totalTicketCount, int manualTicketCount) {
        if (manualTicketCount < LOTTO_MANUAL_DEFAULT_COUNT || manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    @Override
    public List<LottoTicket> generate() {
        return generateManualLottoTickets();
    }

    private List<LottoTicket> generateManualLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String[] lottoNumbers : manualLottoNumbers) {
            lottoTickets.add(generateLottoTicket(lottoNumbers));
        }
        return lottoTickets;
    }

    private LottoTicket generateLottoTicket(String[] lottoNumbers) {
        return new LottoTicket(LottoMachine.sort(LottoMachine.toLottoBalls(lottoNumbers)));
    }
}