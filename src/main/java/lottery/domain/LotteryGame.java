package lottery.domain;

import lottery.dto.LotteryUserDTO;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGame {
    private LotteryAmount lotteryAmount;
    private LotteryWinning lotteryWinning;
    private LotteryTickets lotteryTickets;

    public LotteryGame(int price, int numberOfManual) {
        this.lotteryAmount = new LotteryAmount(price, numberOfManual);
        this.lotteryTickets = new LotteryTickets();
    }

    public LotteryGame(LotteryUserDTO lotteryUserDTO) {
        this.lotteryAmount = new LotteryAmount(lotteryUserDTO.getAmountOfMoney(), lotteryUserDTO.getNumberOfManual());
        this.lotteryTickets = new LotteryTickets();
    }

    public int buyNumberOfLotteryTickets() {
        return lotteryAmount.getAuto();
    }

    public void buyLotteryTickets(List<String> lotteryNumbersByManual) {
        buyLotteryTicketByManual(lotteryNumbersByManual);
        buyLotteryTicketByAutomation(lotteryAmount.getAuto());
    }

    private void buyLotteryTicketByAutomation(int numberOfBuying) {
        this.lotteryTickets.concat(new LotteryTickets(IntStream.range(0, numberOfBuying)
                .boxed()
                .map(Integer -> LotteryTicket.auto())
                .collect(Collectors.toList())));
    }

    private void buyLotteryTicketByManual(List<String> lotteryNumbersByManual) {
        this.lotteryTickets.concat(new LotteryTickets(lotteryNumbersByManual.stream()
                .map(lotteryNumbers -> LotteryTicket.manual(lotteryNumbers))
                .collect(Collectors.toList())));
    }

    public void createLotteryWiningTicket(String lotteryWiningNumbers, String bonusNumber) {
        this.lotteryWinning = new LotteryWinning(lotteryWiningNumbers, bonusNumber);
    }

    public LotteryResult getLotteryResult() {
        return this.lotteryWinning.analyzeLotteryResult(this.lotteryTickets);
    }

    public LotteryTickets getLotteryTickets() {
        return lotteryTickets;
    }
    public LotteryAmount getLotteryAmount() { return lotteryAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryGame that = (LotteryGame) o;
        return Objects.equals(lotteryAmount, that.lotteryAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryAmount);
    }
}
