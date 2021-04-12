package step2.utils;

import step2.domain.LottoTicket;

import java.util.List;

public class PassiveNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> lottoTickets;

    public PassiveNumberGenerator(List<Integer> numbers){
        this.lottoTickets = numbers;
    }

    @Override
    public List<Integer> generate() {
        return lottoTickets;
    }
}
