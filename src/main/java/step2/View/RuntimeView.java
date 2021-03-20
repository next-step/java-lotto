package step2.View;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.dto.ShopResponse;

public class RuntimeView {

    public void printLottoAmount(ShopResponse shopResponse) {
        System.out.println(shopResponse.getLottoCount() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(ShopResponse shopResponse) {
        Lottos lottos = shopResponse.getLottos();
        for(Lotto lotto: lottos.getLottoList()){
            System.out.println(lotto.getNumbers().toString());
        }
    }

}
