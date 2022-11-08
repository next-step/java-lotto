package lotto.dto;

import lotto.domain.LottoTicket;
import lotto.domain.Lottos;

import java.util.List;

public class LottosDto {
    List<LottoTicket> lottosDto;

    public LottosDto(Lottos lottosDto) {
        this.lottosDto = lottosDto.getLottos();
    }

    public List<LottoTicket> getLottosDto(){
        return this.lottosDto;
    }
}
