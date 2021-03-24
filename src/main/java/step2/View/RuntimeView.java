package step2.View;

import step2.dto.LottoListDTO;

public class RuntimeView {

    public void printLottoAmount(LottoListDTO lottoListDTO) {
        System.out.println(lottoListDTO.count() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(LottoListDTO lottoListDTO) {
        for (String numbers : lottoListDTO.getLottoList()) {
            System.out.println(numbers);
        }
    }

}
