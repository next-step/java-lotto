package lottogame.controller.spi;

import java.util.List;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;

public interface Viewer {

    void drawLottoPurchasedResponses(int passiveLottoTicketCount, List<LottoTicketDto> lottoTicketResponses);

    void drawLottoCheckedResponse(LottoCheckedResponse lottoCheckedResponse);

}
