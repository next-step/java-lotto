package lotto.dto;

import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicket;

import java.util.List;

public class LotteryTicketDto {

    private List<Integer> numbers;

    private int price;

    private LotteryPrize lotteryPrize;

    public LotteryTicketDto(LotteryTicket lottoTicket) {
        this.numbers = lottoTicket.getLottoNumberList();
        this.price = lottoTicket.getPrice();
        this.lotteryPrize = lottoTicket.getLotteryPrize();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LotteryPrize getLotteryPrize() {
        return lotteryPrize;
    }
}
