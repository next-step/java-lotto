package lottogame.view;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lottogame.domain.enums.LottoGameRank;
import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoTicket;
import lottogame.domain.user.User;
import lottogame.domain.user.UserLottoResult;

public class OutputView {
    public void printTickets(User user) {
        System.out.printf("%d개를 구매했습니다.\r\n", user.getLottoTickets().size());
        user.getLottoTickets().forEach(this::printLottoTicket);
        System.out.println();
    }

    public void printResult(UserLottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Stream.of(LottoGameRank.FIFTH, LottoGameRank.FOURTH, LottoGameRank.THIRD, LottoGameRank.SECOND, LottoGameRank.FIRST)
            .forEach((rank) -> printReward(rank, result));

        System.out.printf("총 수익률은 %s입니다.\r\n", result.calculateReturnRate());
    }

    public void printError(Exception e) {
        printError(e.getMessage());
    }

    public void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        String numberString = lottoTicket.getLottoNumbers().stream()
            .map(LottoNumber::getValue)
            .map(Object::toString)
            .collect(Collectors.joining(", "));

        System.out.printf("[%s]\r\n", numberString);
    }

    private void printReward(LottoGameRank rank, UserLottoResult result) {
        String printPattern = "%d개 일치 (%d)원- %d개\r\n";

        if (rank == LottoGameRank.SECOND) {
            printPattern = "%d개 일치, 보너스 볼 일치(%d)원- %d개\r\n";
        }

        System.out.printf(printPattern, rank.getMinimumMatchNumberCount(), rank.getReward().getValue(), result.countRank(rank));
    }
}
