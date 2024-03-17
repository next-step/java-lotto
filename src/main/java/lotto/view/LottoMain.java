package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.MyLottos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int pay = scanner.nextInt();
        Integer buyLottoNumber = Amount.getBuyLottoNumber(pay);
        System.out.println(buyLottoNumber + "개를 구매했습니다.");
        MyLottos myLottos = MyLottos.rollLottos(buyLottoNumber);
        for (int i = 0; i < myLottos.getLottoSize(); i++) {
            System.out.println(myLottos.getLottos().get(i).getNumbersToString());
        }
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumber = scanner.next();
        Lotto winLotto = new Lotto(winNumber);
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(3, 0);
        hashMap.put(4, 0);
        hashMap.put(5, 0);
        hashMap.put(6, 0);
        for (int i = 0; i < myLottos.getLottoSize(); i++) {
            long count = myLottos.getLottos().get(i).compareWinNumber(winLotto);
            if (count >= 3) {
                hashMap.put((int) count, hashMap.get((int) count) + 1);
            }
        }
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + hashMap.get(3) + "개");
        System.out.println("4개 일치 (50000원)- " + hashMap.get(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + hashMap.get(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + hashMap.get(6) + "개");

        int totalAmount = 0;
        for (int i = 3; i <= 6; i++) {
            totalAmount += Amount.getAmount(i) * hashMap.get(i);
        }
        System.out.println("총 수익률은 " + (double) totalAmount / (buyLottoNumber * 1000) + "입니다.");
    }
}
