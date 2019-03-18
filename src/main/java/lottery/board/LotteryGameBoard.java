package lottery.board;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;
import lottery.supplier.BoundedUniqueNumbersGenerator;
import lottery.supplier.NumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGameBoard {

    private static final int TICKET_PRICE = 1000;

    private NumbersGenerator numbersGenerator;

    private List<LotteryTicket> lotteryTickets;

    public LotteryGameBoard() {
        this(new BoundedUniqueNumbersGenerator(LotteryNumber.LOWER_BOUND_INCLUSIVE, LotteryNumber.UPPER_BOUND_INCLUSIVE));
    }

    public LotteryGameBoard(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public int buyLotteryTicket(int price) {
        final int ticketCount = price / TICKET_PRICE;
        this.lotteryTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> new LotteryTicket(numbersGenerator.nextNumbers(LotteryTicket.NUMBERS_COUNT)))
                .collect(Collectors.toList());
        return lotteryTickets.size();
    }

    public List<LotteryRank> checkWinningNumbers(List<Integer> winningNumbers) {
        final LotteryTicket winningTicket = new LotteryTicket(winningNumbers);

        return this.lotteryTickets
                .stream()
                .map(lotteryTicket -> lotteryTicket.getWinningRank(winningTicket))
                .collect(Collectors.toList());
    }

    public List<LotteryTicket> getTickets() {
        return this.lotteryTickets;
    }
}
