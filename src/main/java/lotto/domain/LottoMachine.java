package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static int LOTTOPRICE = 1000;
    private static GenerateLotto GENERATE_LOTTO = new GenerateLotto();

    public static int calculatePurchaseNum(int purchaseAmount){
        validatePurchaseAmount(purchaseAmount);
        int purchaseNum = purchaseAmount / LOTTOPRICE;
        return purchaseNum;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if ( purchaseAmount < 1000 || (purchaseAmount%1000 != 0)) {
            throw new IllegalStateException("로또금액은 1000원 이상이며, 단위는 1000  입니다."); }
    }

    public static List<Lotto> ticketingLotto(int purchaseNum){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0 ; i < purchaseNum ; i++) {
            lottos.add(new Lotto(GENERATE_LOTTO.generateAuto()));
        }

        return  lottos;
    }

}
