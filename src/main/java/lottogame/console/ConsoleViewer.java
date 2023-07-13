package lottogame.console;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lottogame.controller.spi.Viewer;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketCheckedResponse;

public class ConsoleViewer implements Viewer {

    @Override
    public void drawLottoTicketResponses(List<LottoTicketDto> lottoTicketRespons) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicketRespons.size());
        System.out.println(parsePrintString(lottoTicketRespons));
    }

    private String parsePrintString(List<LottoTicketDto> lottoTicketRespons) {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTicketRespons.forEach(
            lottoTicketResponse -> parseLottoTicket(lottoTicketResponse.getNumbers(), stringBuilder));

        return stringBuilder.toString();
    }

    private void parseLottoTicket(Set<Integer> lottoTicket, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        stringBuilder.append(new TreeSet<>(lottoTicket).stream()
            .map(lottoNumber -> Integer.toString(lottoNumber))
            .collect(Collectors.joining(", ")));
        stringBuilder.append("]\n");
    }

    @Override
    public void drawLottoCheckedResponse(LottoCheckedResponse lottoCheckedResponse) {
        System.out.println("당첨 통계\n---------");
        lottoCheckedResponse.getLottoTicketCheckResponses().entrySet().forEach(this::printLottoPrize);
        printEarningRate(lottoCheckedResponse.getEarningRate());
    }

    private void printLottoPrize(Map.Entry<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", lottoTicketCheckResponses.getKey().getMatchedCount(),
            lottoTicketCheckResponses.getKey().getMoney(), lottoTicketCheckResponses.getValue());
    }

    private void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", earningRate);
    }
}
