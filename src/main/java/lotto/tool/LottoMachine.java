package lotto.tool;

import lotto.domain.LottoBall;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_MANUAL_DEFAULT_COUNT = 0;

    public static LottoBundle issueTickets(LottoMoney lottoMoney, List<String[]> manualLottoNumbers) {
        checkManualTicketCount(lottoMoney.buy(), manualLottoNumbers.size());
        return issueLottoTickets(lottoMoney, manualLottoNumbers);
    }

    public static boolean checkManualTicketCount(int totalTicketCount, int manualTicketCount) {
        if (manualTicketCount < LOTTO_MANUAL_DEFAULT_COUNT || manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static LottoBundle issueLottoTickets(LottoMoney lottoMoney, List<String[]> manualLottoNumbers) {
        List<LottoTicket> lottoManualTickets = issueTickets(new LottoManualGenerator(manualLottoNumbers, lottoMoney));
        List<LottoTicket> lottoRandomTickets = issueTickets(new LottoRandomGenerator(lottoMoney.buy() - lottoManualTickets.size()));
        return new LottoBundle(merge(lottoManualTickets, lottoRandomTickets));
    }

    private static List<LottoTicket> issueTickets(LottoGenerator lottoGenerator) {
        return lottoGenerator.generate();
    }

    private static List<LottoTicket> merge(List<LottoTicket> lottoManualTickets, List<LottoTicket> lottoRandomTickets) {
        for (LottoTicket lottoTicket : lottoRandomTickets) {
            lottoManualTickets.add(lottoTicket);
        }
        return lottoManualTickets;
    }

    public static List<LottoBall> toLottoBalls(String[] lottoNumbers) {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (String winningNumber : lottoNumbers) {
            lottoBalls.add(new LottoBall(toInt(winningNumber)));
        }
        return sort(lottoBalls);
    }

    public static Integer toInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<LottoTicket> generateManualTickets(LottoGenerator lottoGenerator) {
        return lottoGenerator.generate();
    }

    public static List<LottoBall> sort(List<LottoBall> lottoBalls) {
        Collections.sort(lottoBalls);
        return lottoBalls;
    }
}
