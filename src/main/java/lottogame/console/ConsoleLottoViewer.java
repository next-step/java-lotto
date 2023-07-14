package lottogame.console;

import lottogame.controller.spi.LottoViewer;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoTicket;
import lottogame.service.response.LottoCheckResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsoleLottoViewer implements LottoViewer {
    @Override
    public void draw(List<LottoTicket> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        System.out.println(parsePrintString(lottoTickets));
    }

    private String parsePrintString(List<LottoTicket> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTickets.forEach(lottoTicket -> parseLottoTicket(lottoTicket.getValues(), stringBuilder));

        return stringBuilder.toString();
    }

    private void parseLottoTicket(Set<Integer> lottoTicket, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        stringBuilder.append(new TreeSet<>(lottoTicket).stream()
                .map(lottoNumber -> Integer.toString(lottoNumber))
                .collect(Collectors.joining(", ")));
        stringBuilder.append("]\n");
    }

    public void draw(LottoCheckResponse lottoCheckResponse) {
        System.out.println("당첨 통계\n---------");
        lottoCheckResponse.getLottoPrizeCounts().entrySet().stream()
                .filter(lottoPrizeLongEntry -> lottoPrizeLongEntry.getKey() != LottoPrize.NONE)
                .forEach(this::printLottoPrize);
        printEarningRate(lottoCheckResponse.getEarningRate());
    }

    private void printLottoPrize(Map.Entry<LottoPrize, Long> lottoPrizeCount) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", lottoPrizeCount.getKey().getMatchedCount(),
                lottoPrizeCount.getKey().getMoney(), lottoPrizeCount.getValue());
    }

    private void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", earningRate);
    }
}
