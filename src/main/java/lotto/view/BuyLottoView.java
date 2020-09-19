package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.Scanner;

public class BuyLottoView {
    private BuyLottoView(){}
    public static Lottos buyLotto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력 해 주세요.");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoAmount = Integer.parseInt(scanner.nextLine());

        if(manualLottoAmount > 0 ){
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }

        String[] manualLottoStrArr = new String[manualLottoAmount];
        for(int i = 0 ; i < manualLottoAmount ; i ++){

            manualLottoStrArr[i] = scanner.nextLine();
        }

        Lottos lottos = LottoStore.sold(price, manualLottoStrArr);

        print(lottos, manualLottoAmount);

        return lottos;
    }

    private static void print(Lottos lottos, int manualLottoAmount){
        System.out.println("수동으로 "+manualLottoAmount+"장, 자동으로 "+(lottos.getSize()-manualLottoAmount)+"장을 구매했습니다.");
        System.out.println(lottos);
    }
}
