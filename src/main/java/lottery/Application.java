package lottery;


import lottery.machine.LotteryMachine;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        LotteryMachine machine = new LotteryMachine();
        final int price = InputView.inputPrice();
        final int count = machine.buyLotteryTicket(price);

        InputView.viewTicketCount(count);
        ResultView.viewTickets(machine.getTickets());

        ResultView.viewStatistics(machine.checkWinningNumbers(InputView.inputWinningNumbers()));
    }
}
