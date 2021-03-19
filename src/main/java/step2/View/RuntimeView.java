package step2.View;

import step2.dto.ShopResponse;

public class RuntimeView {

    public void printLottoAmount(ShopResponse shopResponse) {
        System.out.println(shopResponse.getLottoCount() + "개를 구매했습니다.");
    }


    public void printLottoNumbers(ShopResponse shopResponse) {
        shopResponse.getLottoList()
                .forEach((lotto -> System.out.println(lotto.getNumbers().toString())));
    }



}
