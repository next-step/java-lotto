package lottery;

import lottery.domain.*;
import lottery.dto.LotteryUserDTO;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

public class LotteryGameManager {
    public static void main(String[] args) {
        LotteryUserDTO lotteryUserDTO = new LotteryUserDTO(
                Integer.parseInt(InputViewLotteryGame.getUserInvestAmount()),
                Integer.parseInt(InputViewLotteryGame.getNumberOfLotterysByManual()));
        LotteryGame lotteryGame = new LotteryGame(lotteryUserDTO);

        lotteryGame.buyLotteryTickets(
                InputViewLotteryGame.getUserLotteryTicketNumbersByManual(
                        lotteryUserDTO.getNumberOfManual()));

        ResultViewLotteryGame.displayNumberOfTickets(lotteryGame.getLotteryAmount());
        ResultViewLotteryGame.displayPurchasedTickets(lotteryGame.getLotteryTickets());

        lotteryGame.createLotteryWiningTicket(
                InputViewLotteryGame.getWinningNumbers(),
                InputViewLotteryGame.getBonusNumber());

        ResultViewLotteryGame.displayLotteryResult(
                lotteryGame.getLotteryResult(),
                lotteryGame.getLotteryAmount());
    }
}
