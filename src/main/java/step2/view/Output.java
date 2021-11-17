package step2.view;

import step2.domain.LottoList;

import java.util.Arrays;
import java.util.List;

public class Output {
    private static List<Integer> prizeList = Arrays.asList(0,0,0,5000, 50000, 1500000, 2000000000);

    public static void viewPurchasedLotto(LottoList lottoList) {
        lottoList.getLottoList().stream().map(randomNumbers -> randomNumbers.getLottoNumbers()).forEach(System.out::println);
    }

    public static void viewResult(List<Integer> countList) {
        for (int i = 3; i < countList.size(); i++) {
            System.out.println(i);
            System.out.println(i + "개 일치 ("+prizeList.get(i)+")-"+countList.get(i)+"개");
        }
    }

}
