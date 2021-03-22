package step2.View;

import step2.dto.LottoDTO.NormalLottoDTO;
import step2.dto.LottoListDTO;
import step2.dto.ShopResponseDTO;

public class RuntimeView {

    public void printLottoAmount(ShopResponseDTO shopResponse) {
        System.out.println(shopResponse.getLottoCount() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(ShopResponseDTO shopResponse) {
        LottoListDTO lottoList = shopResponse.getLottoList();
        for (NormalLottoDTO lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

}
