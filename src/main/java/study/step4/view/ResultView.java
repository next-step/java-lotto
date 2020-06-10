package study.step4.view;

import study.step4.domain.*;
import study.step4.dto.LottoOutputDto;

import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    public static void printLottoTickets(LottoOutputDto lottoOutputDto) {
        countTotalLottoTickets(lottoOutputDto);
        List<LottoTicket> tickets = lottoOutputDto.getlottoTickets();
        for (LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.getLottoNumbersForPrint());
        }
    }

    private static void countTotalLottoTickets(LottoOutputDto lottoOutputDto) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                lottoOutputDto.getManualLottoAmount(),lottoOutputDto.getAutoLottoAmount()));
    }

    public static void printLottoResult(LottoOutputDto lottoOutputDto, WinningLotto winningLotto) {
        WinningRanks winningRanks = lottoOutputDto.getObjectLottoTickets().confirmWinningResult(winningLotto);
        Stream.of(WinningRank.values())
              .filter(rank -> !WinningRank.NOTHING.equals(rank))
              .forEach(rank -> System.out.println(String.format("[%s] %d개 일치 (%d원)- %d개",
                      rank.name(),rank.getMatchingCount(),rank.getPrizeMoney(),winningRanks.countRank(rank))));

        System.out.println(String.format("총 수익률은 %.2f입니다.",winningRanks.calculateEarningsRate()));
    }
}