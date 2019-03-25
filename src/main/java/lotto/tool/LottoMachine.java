package lotto.tool;

import lotto.domain.LottoBall;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_MANUAL_DEFAULT_COUNT = 0;

    public static List<LottoTicket> issueTickets(LottoMoney lottoMoney, List<String[]> manualLottoNumbers) {
        int totalCount = lottoMoney.buy();
        int manualCount = manualLottoNumbers.size();
        int autoCount = lottoMoney.buy() - manualCount;

        checkManualTicketCount(totalCount, manualCount);
        List<LottoTicket> lottoTickets = issueManualTickets(manualLottoNumbers);

        for (int i = 0; i < autoCount; i++) {
            lottoTickets.add(new LottoTicket(LottoAutoGenerator.random()));
        }
        return lottoTickets;
    }

    public static boolean checkManualTicketCount(int totalTicketCount, int manualTicketCount) {
        if (manualTicketCount < LOTTO_MANUAL_DEFAULT_COUNT || manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static List<LottoTicket> issueManualTickets(List<String[]> manualLottoNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (String[] manualNumber : manualLottoNumbers) {
            lottoTickets.add(new LottoTicket(toLottoBalls(manualNumber)));
        }

        return lottoTickets;
    }

    public static List<LottoBall> toLottoBalls(String[] lottoNumbers) {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (String winningNumber : lottoNumbers) {
            lottoBalls.add(new LottoBall(toInt(winningNumber)));
        }
        return LottoAutoGenerator.sort(lottoBalls);
    }

    public static Integer toInt(String number) {
        return Integer.parseInt(number);
    }
}
