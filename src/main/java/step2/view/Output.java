package step2.view;

import step2.domain.Lottos;
import step2.domain.Prize;

import java.util.List;

public class Output {

    private Output() {
    }

    public static void viewPurchasedLotto(Lottos lottos) {
        lottos.getLottos().stream().map(randomNumbers -> randomNumbers.getLottoNumbers()).forEach(System.out::println);
    }

    public static void viewResult(List<Integer> matchingList,Integer purchaseAmount) {
        for (int i = 3; i < matchingList.size(); i++) {
            System.out.println(i + "개 일치 ("+ Prize.prizeList.get(i)+")-"+matchingList.get(i)+"개");
        }
        System.out.println("총 수익률은 "+Prize.calculatorYield(matchingList,purchaseAmount)+"입니다.");
    }
}
