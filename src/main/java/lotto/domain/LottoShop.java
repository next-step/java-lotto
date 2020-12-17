package lotto.domain;

import java.text.MessageFormat;
import java.util.List;

public class LottoShop {

    public static final String NOT_MATCH_MANUAL_LOTTO_COUNT_ERROR = "입력한 수동 로또 갯수가 {0}개가 아닙니다.";

    public PublishedLottoTicket buyLotto(LottoTicketCount lottoTicketCount, List<String> manualLottoNumbers) {
        validateManualLottoNumbers(lottoTicketCount, manualLottoNumbers);

        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket.Builder()
                .autoLottoTicketCount(lottoTicketCount.getAutoLottoTicketCount())
                .manualLottoNumbers(manualLottoNumbers)
                .build();

        return publishedLottoTicket;
    }

    private void validateManualLottoNumbers(LottoTicketCount lottoTicketCount, List<String> manualLottoNumbers) {
        int manualLottoTicketCount = lottoTicketCount.getManualLottoTicketCount();
        if (manualLottoTicketCount != manualLottoNumbers.size()) {
            String msg = MessageFormat.format(NOT_MATCH_MANUAL_LOTTO_COUNT_ERROR, manualLottoTicketCount);
            throw new IllegalArgumentException(msg);
        }
    }

}
