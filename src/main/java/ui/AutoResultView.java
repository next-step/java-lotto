package ui;

import domain.lottery.LotteryWinningService;
import domain.ticket.TicketCountService;
import domain.ticket.TicketNumberService;
import ui.common.InputView;
import ui.common.Result;
import dto.lottery.LotteryTicket;
import dto.lottery.LotteryTickets;
import dto.lottery.WinnerLotteryTicket;
import util.Calculator;
import util.Converter;

import java.util.List;

import static constant.LotteryRules.DEFAULT_LOTTERY_TICKET_PRICE;

public class AutoResultView implements Result {
    private final String DELIMITER = ", ";
    private LotteryTickets lotteryTickets;
    private WinnerLotteryTicket winnerLotteryTicket;

    @Override
    public void printAll() {
        LotteryWinningService lotteryWinningService = new LotteryWinningService();
        TicketNumberService ticketNumberService = new TicketNumberService();
        TicketCountService ticketCountService = new TicketCountService();

        printTicketNumbers(ticketCountService, ticketNumberService);
        printLotteryResult(lotteryWinningService, ticketNumberService);
    }

    @Override
    public void printTicketNumbers(TicketCountService ticketCountService, TicketNumberService ticketNumberService) {
        System.out.println("구입금액을 입력해 주세요.");

        long countOfLotteryTickets = ticketCountService.countOfLotteryTickets(InputView.inputInteger());
        System.out.println(countOfLotteryTickets + "개를 구매했습니다.");

        List<LotteryTicket> lotteryTicketList = ticketNumberService.generateLotteryTicketNumbers(countOfLotteryTickets);
        lotteryTickets = new LotteryTickets(lotteryTicketList);

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            System.out.println(lotteryTicket.getTicketNumbers());
        }

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LotteryTicket winnerTicket = Converter.convertStringToLotteryTicket(InputView.inputString().split(DELIMITER));

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusTicketNumber = InputView.inputInteger();
        winnerLotteryTicket = new WinnerLotteryTicket(winnerTicket, bonusTicketNumber);
    }

    @Override
    public void printLotteryResult(LotteryWinningService lotteryWinningService, TicketNumberService ticketNumberService) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + lotteryWinningService.countOfLotteryWinners(3, lotteryTickets.getLotteryTickets(), winnerLotteryTicket, ticketNumberService) + "개");
        System.out.println("4개 일치 (50000원)- " + lotteryWinningService.countOfLotteryWinners(4, lotteryTickets.getLotteryTickets(), winnerLotteryTicket, ticketNumberService) + "개");
        System.out.println("5개 일치 (1500000원)- " + lotteryWinningService.countOfLotteryWinners(5, lotteryTickets.getLotteryTickets(), winnerLotteryTicket, ticketNumberService) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lotteryWinningService.countOfLotteryWinners(5.5, lotteryTickets.getLotteryTickets(), winnerLotteryTicket, ticketNumberService) + "개");
        System.out.println("6개 일치 (2000000000원)- " + lotteryWinningService.countOfLotteryWinners(6, lotteryTickets.getLotteryTickets(), winnerLotteryTicket, ticketNumberService) + "개");
        System.out.println("총 수익률은 " + Calculator.rateOfProfit((long) lotteryTickets.getLotteryTickets().size() * DEFAULT_LOTTERY_TICKET_PRICE, lotteryWinningService.findTotalRewards(lotteryTickets, winnerLotteryTicket, ticketNumberService)) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
