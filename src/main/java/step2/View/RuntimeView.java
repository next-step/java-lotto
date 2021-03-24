package step2.View;

import step2.dto.LottoListDTO;

public class RuntimeView {

    public void printLottoAmount(int manualLottoCount, int autoLottoCount) {
        String printString = String.format("수동으로 %d장, 자동으로 %d장을 구입했습니다.", manualLottoCount, autoLottoCount);
        System.out.println(printString);
    }

    public void printLottoNumbers(LottoListDTO lottoListDTO) {
        for (String numbers : lottoListDTO.getLottoList()) {
            System.out.println(numbers);
        }
    }

}
