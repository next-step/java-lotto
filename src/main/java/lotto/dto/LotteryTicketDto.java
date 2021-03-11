package lotto.dto;

import lotto.domain.LotteryTicket;

import java.util.List;

public class LotteryTicketDto {

    private List<Integer> numbers;

    private int price;

    public LotteryTicketDto(LotteryTicket lottoTicket) {
        this.numbers = lottoTicket.getLottoNumberList();
        this.price = lottoTicket.getPrice();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
