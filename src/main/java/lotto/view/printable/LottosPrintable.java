package lotto.view.printable;

import lotto.dto.LottosDto;

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
