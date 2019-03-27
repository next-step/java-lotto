package lotto.tool;

import lotto.domain.LottoBall;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_MANUAL_DEFAULT_COUNT = 0;

    public static LottoBundle issueTickets(LottoMoney lottoMoney, List<String[]> manualLottoNumbers) {
        //TODO : 한가지 일만 하도록 변경 ( 수동티켓 발급 가능여부 판단, 수동티켓 발급하기 , 자동티켓 발급하기 )
        //TODO : 콘솔에서 각각 호출하도록 변경하는게 좋은건가?
        checkManualTicketCount(lottoMoney.buy(), manualLottoNumbers.size());
//        List<LottoTicket> lottoTickets = issueManualTickets(manualLottoNumbers);

//        return new LottoBundle(issueAutoTickets(lottoTickets, lottoMoney.buy() - manualLottoNumbers.size()));
        return issueLottoTickets(lottoMoney, manualLottoNumbers);
    }

//    private static List<LottoTicket> issueAutoTickets(List<LottoTicket> lottoTickets, int autoIssueCount) {
//        for (int i = 0; i < autoIssueCount; i++) {
//            lottoTickets.add(new LottoTicket(LottoAutoGenerator.random()));
//        }
//        return lottoTickets;
//    }

    public static boolean checkManualTicketCount(int totalTicketCount, int manualTicketCount) {
        if (manualTicketCount < LOTTO_MANUAL_DEFAULT_COUNT || manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException();
        }
        return true;
    }

//    public static List<LottoTicket> issueManualTickets(List<String[]> manualLottoNumbers) {
//        List<LottoTicket> lottoTickets = new ArrayList<>();
//
//        for (String[] manualNumber : manualLottoNumbers) {
//            lottoTickets.add(new LottoTicket(toLottoBalls(manualNumber)));
//        }
//
//        return lottoTickets;
//    }

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
        return LottoAutoGenerator.sort(lottoBalls);
    }

    public static Integer toInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<LottoTicket> generateManualTickets(LottoGenerator lottoGenerator) {
        return lottoGenerator.generate();
    }
}
