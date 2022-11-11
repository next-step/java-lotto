package ui;

import domain.lottery.RewardLotteryTickets;
import service.LotteryService;
import ui.common.InputView;
import ui.common.Result;
import domain.lottery.LotteryTicket;
import domain.lottery.LotteryTickets;
import domain.lottery.WinnerLotteryTicket;
import util.Calculator;
import util.Converter;

import static constant.LotteryRules.DEFAULT_LOTTERY_TICKET_PRICE;

public class AutoResultView implements Result {
    private final String DELIMITER = ", ";
    private LotteryTickets lotteryTickets;
    private WinnerLotteryTicket winnerLotteryTicket;
    private RewardLotteryTickets rewardLotteryTickets;

    @Override
    public void printAll() {
        LotteryService lotteryService = new LotteryService();

        printTicketNumbers();
        printLotteryResult(lotteryService);
    }

    @Override
    public void printTicketNumbers() {
        System.out.println("구입금액을 입력해 주세요.");

        long amount = InputView.inputInteger();

        lotteryTickets = new LotteryTickets(amount);
        System.out.println(lotteryTickets.getLotteryTickets().size() + "개를 구매했습니다.");

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            System.out.println(lotteryTicket.getTicketNumbers());
        }

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LotteryTicket winnerTicket = Converter.convertStringToLotteryTicket(InputView.inputString().split(DELIMITER));

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusTicketNumber = InputView.inputInteger();
        winnerLotteryTicket = new WinnerLotteryTicket(winnerTicket, bonusTicketNumber);
        rewardLotteryTickets = new RewardLotteryTickets(lotteryTickets, winnerLotteryTicket);
    }

    @Override
    public void printLotteryResult(LotteryService lotteryService) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + lotteryService.countOfLotteryWinners(3, rewardLotteryTickets) + "개");
        System.out.println("4개 일치 (50000원)- " + lotteryService.countOfLotteryWinners(4, rewardLotteryTickets) + "개");
        System.out.println("5개 일치 (1500000원)- " + lotteryService.countOfLotteryWinners(5, rewardLotteryTickets) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lotteryService.countOfLotteryWinners(7, rewardLotteryTickets) + "개");
        System.out.println("6개 일치 (2000000000원)- " + lotteryService.countOfLotteryWinners(6, rewardLotteryTickets) + "개");
        System.out.println("총 수익률은 " + Calculator.rateOfProfit((long) lotteryTickets.getLotteryTickets().size() * DEFAULT_LOTTERY_TICKET_PRICE, lotteryService.findTotalRewards(new RewardLotteryTickets(lotteryTickets, winnerLotteryTicket))) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
