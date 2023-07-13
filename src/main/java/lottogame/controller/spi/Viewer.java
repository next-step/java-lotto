package lottogame.controller.spi;

import java.util.List;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketResponse;

public interface Viewer {

    void drawLottoTicketResponses(List<LottoTicketResponse> lottoTicketResponses);

    void drawLottoCheckedResponse(LottoCheckedResponse lottoCheckedResponse);

}
