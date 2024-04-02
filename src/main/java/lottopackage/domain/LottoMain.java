package lottopackage.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        List<Integer> totalList = lotto.getTotalLottoNumber();

        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> testList2 = new ArrayList<>(Arrays.asList(3, 2, 5));
        testList.removeAll(testList2);
        System.out.println(testList.size());

    }
}
