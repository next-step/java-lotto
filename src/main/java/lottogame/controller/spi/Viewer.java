package lottogame.controller.spi;

import java.util.List;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;

public interface Viewer {

    void drawLottoTicketResponses(List<LottoTicketDto> lottoTicketRespons);

    void drawLottoCheckedResponse(LottoCheckedResponse lottoCheckedResponse);

}
