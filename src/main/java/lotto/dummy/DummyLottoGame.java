package lotto.dummy;

import java.util.*;

/***
 * 막코딩용 클래스
 *
 * 1. 돈 -> 로또발급
 *  - 발급장수 기준 : 1_000원 / 장
 *      > 1_000원 미만 -> error
 *      > 1_000원 이상 2_0000미만 -> 1장
 *      > 2_000원 ~ -> 2장...
 *
 *  - 발급번호 기준
 *      > 1 - 45 사이 번호
 *      > 중복 안 됨
 *      > 6개 숫자
 *
 *
 *
 * 2. 당첨번호입력 -> 당첨로또생성
 *  - 당첨번호 기준
 *      > 발급번호 기준과 동일
 *
 * 3. 보너스번호 입력 -> 보너스번호 저장
 *  - 보너스번호 기준
 *      > 당첨번호와 중복되면 안 됨
 *
 * 4. 당첨개수 확인
 * 5. 보너스당첨 확인 ( 5개 일치할때만 )
 *
 * 6. 수익률 계산
 *
 * 7. 결과출력
 */

public class DummyLottoGame {

    public static final List<Integer> basicLotto;
    static {
        basicLotto = new ArrayList<>();
        for (int i = 0; i < 45 ; i++) {
            basicLotto.add(i+1);
        }
    }

    public static void main(String[] args) {
        //1. 돈 -> 로또발급
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        int ticketCount = money / 1000;

        List<List<Integer>> lotto = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            //로또번호 생성
            List<Integer> ticket = new ArrayList<Integer>();

            Collections.shuffle(basicLotto);
            for (int j = 0; j < 6; j++) {
                ticket.add(basicLotto.get(j));
            }
            lotto.add(ticket);
        }


        //2. 당첨번호입력 -> 당첨로또생성
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputWinningNumbers = scanner.nextLine().split(", ");
        for (String winningNumber : inputWinningNumbers) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        //3. 보너스번호 입력 -> 보너스번호 저장
        int bonusNumber = scanner.nextInt();

        //4. 당첨개수 확인
        int[] winningCount = new int[6];
        int bonusMatchCount = 0;
        for (List<Integer> numbers : lotto) {
            int count = 0;
            for (Integer winningNumber : winningNumbers) {
                if (numbers.contains(winningNumber)) {
                    count++;
                }
            }
            //5. 보너스당첨 확인 ( 5개 일치할때만 )
            if (count == 5) {
                if (numbers.contains(bonusNumber)) {
                    bonusMatchCount++;
                }
            } else {
                winningCount[count]++;
            }
        }

        //6. 수익률 계산
        double rate = 0.0;
        for (int i = 3; i < winningCount.length; i++) {
            if (i == 3) {
                rate += winningCount[i] * 5000;
            } else if (i == 4) {
                rate += winningCount[i] * 50000;
            } else if (i == 5) {
                rate += winningCount[i] * 1500000;
            } else if (i == 6) {
                rate += winningCount[i] * 2000000000;
            }
        }

        if (bonusMatchCount > 0) {
            rate += bonusMatchCount * 30000000;
        }

        rate /= money;

        //7. 결과출력
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
