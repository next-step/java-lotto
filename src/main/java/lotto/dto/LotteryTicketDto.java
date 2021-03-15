package lotto.dto;

import lotto.domain.LotteryCreatedType;
import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicket;

import java.util.List;

public class LotteryTicketDto {

    private List<Integer> numbers;

    private int price;

    private LotteryPrize lotteryPrize;

    private LotteryCreatedType createdType;

    public LotteryTicketDto(LotteryTicket lottoTicket) {
        this.numbers = lottoTicket.getLottoNumberList();
        this.price = lottoTicket.getPrice();
        this.lotteryPrize = lottoTicket.getLotteryPrize();
        this.createdType = lottoTicket.getCreatedType();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LotteryPrize getLotteryPrize() {
        return lotteryPrize;
    }

    public int getPrice() {
        return price;
    }

    public LotteryCreatedType getCreatedType() {
        return createdType;
    }
}
