package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottos(List<Lotto> lottos){
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        lottos.forEach(lotto -> printLotto(lotto));
        System.out.println();
    }

    public static void printLottoResult(){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    private static void printLotto(Lotto lotto) {
       List<Integer> nums = lotto.getNums();
       System.out.println(nums);
    }

}
