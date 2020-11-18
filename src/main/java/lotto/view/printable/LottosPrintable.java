package lotto.view.printable;

import lotto.dto.result.LottosDto;

public class LottosPrintable extends Printable {
    private final LottosDto dto;

    public LottosPrintable(LottosDto lottosDto) {
        dto = lottosDto;
    }

    @Override
    public void print() {
        println(dto.getLottos());
    }
}
