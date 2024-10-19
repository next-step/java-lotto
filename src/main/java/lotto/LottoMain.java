package lotto;

import random.LottoGenerateStrategy;
import random.LottoGenerator;
import random.RandomLottoNumbers;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int perchaseAmount = scanner.nextInt();
        System.out.println(perchaseAmount);

        Lotto lotto = Lotto.InitLotto();
        System.out.println(lotto.calculateLottoTryCount(perchaseAmount) + "개를 구매했습니다.");
        LottoGenerator lottoGenerator = new LottoGenerateStrategy(new RandomLottoNumbers());
        lotto.makeLottoList(lottoGenerator);
        lotto.printLottoList();

        System.out.println("지난주 당첨 번호를 입력해주세요");

        //TODO 당첨번호 입력 문자열로 받아서 배열처리
        //TODO 당첨 통계 작성.


    }

}
