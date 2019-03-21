package lottery.machine;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryWinningStatistics;
import lottery.domain.WinningTicket;
import lottery.supplier.BoundedUniqueNumbersGenerator;
import lottery.supplier.NumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {

    private NumbersGenerator numbersGenerator;

    private List<LotteryTicket> lotteryTickets;

    public LotteryMachine() {
        this(new BoundedUniqueNumbersGenerator(LotteryNumber.LOWER_BOUND_INCLUSIVE, LotteryNumber.UPPER_BOUND_INCLUSIVE));
    }

    public LotteryMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public int buyLotteryTicket(int price) {
        final int ticketCount = price / LotteryTicket.PRICE;
        this.lotteryTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> new LotteryTicket(numbersGenerator.nextNumbers(LotteryTicket.NUMBERS_COUNT)))
                .collect(Collectors.toList());
        return lotteryTickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return this.lotteryTickets;
    }

    public LotteryWinningStatistics raffle(List<Integer> winningNumbers, int bonusNumber) {
        return new LotteryWinningStatistics(new WinningTicket(winningNumbers, bonusNumber), this.lotteryTickets);
    }
}
