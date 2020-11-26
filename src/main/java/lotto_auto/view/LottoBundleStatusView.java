package lotto_auto.view;

import lotto_auto.model.LottoBundle;
import lotto_auto.model.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundleStatusView {

    private static final String LOTTO_TICKET_BUY_MESSAGE = "수동으로 %d장, 자동으로 %d장 구매했습니다.";

    public static void statusPrint(LottoBundle lottoBundle) {
        List<LottoTicket> lottoTicketList = lottoBundle.export();
        System.out.println(String.format(LOTTO_TICKET_BUY_MESSAGE, lottoBundle.getManual(), lottoBundle.getAuto()));
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTicketList) {
            sb.append(printLottoTicket(lottoTicket));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static String printLottoTicket(LottoTicket lottoTicket) {

        String collect = lottoTicket
                .getLottoNumbers()
                .export()
                .stream()
                .map(item -> String.valueOf(item.getNumber()))
                .collect(Collectors.joining(", "));
        return String.format("[ %s ]", collect);
    }
}
