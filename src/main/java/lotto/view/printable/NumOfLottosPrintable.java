package lotto.view.printable;

import lotto.dto.result.NumOfLottosDto;

public class NumOfLottosPrintable extends Printable {
    private final NumOfLottosDto dto;

    public NumOfLottosPrintable(NumOfLottosDto numOfLottosDto) {
        dto = numOfLottosDto;
    }

    @Override
    public void print() {
        println(dto.getNumOfLottos() + "개를 구매했습니다.");
    }
}
