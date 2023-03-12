package lotto;

import java.util.Scanner;

public class lottoGenerator {

    private int test = 0;



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = in.nextLine();

        //14개를 구매했습니다. 출력구현필요 & 아래와 같이 대상을 출력도 필요
        // [8, 21, 23, 41, 42, 43]
        // [3, 5, 11, 16, 32, 38] ...

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWeekWinNumber = in.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = in.nextLine();

        //당첨통계등 report구성하기
        // 당첨 통계
        //---------
        // 3개 일치 (5000원)- 1개
        // 4개 일치 (50000원)- 0개 ...
        // 5개 일치 (1500000원)- 0개
        // 5개 일치, 보너스 볼 일치(30000000원) - 0개
        // 6개 일치 (2000000000원)- 0개
        // 총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

        // [추가된 요구 사항]s
        //배열 대신 컬렉션을 사용한다.
        //Java Enum을 적용한다.
        //모든 원시 값과 문자열을 포장한다
        //줄여 쓰지 않는다(축약 금지).
        //일급 컬렉션을 쓴다.

    }
}
