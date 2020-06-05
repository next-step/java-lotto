package lottery;

public class Main {

    public static void main(String[] args) {/*
        PurchasePrice purchasePrice = PurchasePrice.of(InputView.getInputPurchasePrice(),
                InputView.getInputManualTicketCounts());
        ManualTicketsNumbersDto manualTicketsNumbersDto =
                new ManualTicketsNumbersDto(InputView.getInputManualTicketsNumbers(purchasePrice));
        LotteryStore lotteryStore = LotteryStore.getInstance();
        LotteryTicketsGroup lotteryTicketsGroup = lotteryStore.publishLotteryTicketsGroup(purchasePrice);

        ResultView.printLotteryGameInformation(purchasePrice, lotteryTicketsGroup);

        LotteryTicket lastWinnerTicket = LotteryTicket.from(InputView.getInputLastWinnerTicketNumbers());
        BonusBall bonusBall = BonusBall.of(InputView.getInputBonusBallNumber(), lastWinnerTicket);

        LotteryGame lotteryGame = LotteryGame.getInstance();
        LotteryGameResult lotteryGameResult = lotteryGame
                .drawWinnerLotteryTickets(lotteryTicketsGroup, lastWinnerTicket, bonusBall);
        RateOfReturn rateOfReturn = lotteryGameResult.calculateRateOfReturn(purchasePrice);

        ResultView.printLotteryGameResult(lotteryGameResult);
        ResultView.printRateOfReturn(rateOfReturn);*/
    }
}
