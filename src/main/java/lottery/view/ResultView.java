package lottery.view;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoTicketCounts(int lotteryTicketCounts) {
        System.out.println(lotteryTicketCounts + ViewMessages.RESULT_LOTTERY_TICKET_COUNTS);
    }
}
