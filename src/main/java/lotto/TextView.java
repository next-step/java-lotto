package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * 텍스트 UI 출력 함수 클래스
 */
public class TextView {

    /**
     * 로또 당첨 상태 출력 함수
     */
    public static void printLottoValue(int matchCount, boolean bouns, int prize) {
        if (bouns) {
            System.out.print(matchCount + "개 일치, 보너스 볼 일치(" + prize + ")");
        }
        if (!bouns) {
            System.out.print(matchCount + "개 일치 (" + prize + ")");
        }
    }

    /**
     * 생성된 로또 번호 출력
     *
     * @param lottoNumber
     */
    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    /**
     * 사용자 지갑의 로또 총 당첨 통계 작업 함수
     *
     * @param wallet 사용자 지갑
     * @param budget 금액
     */
    public static void printCustomerLottoResult(Wallet wallet, int budget) { // 지갑에 최초 예산 금액 저장하기.
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        // 등수 몇개 맞았는지
        printLottoResult(wallet, LottoGrade.values());
        // 수익률
        printYieldRate(wallet, budget);
    }

    /**
     * 지갑의 총 상금 계산
     * @param wallet
     * @return
     */
    public static int getTotalPrize(Wallet wallet) {
        return wallet.getLottos().stream().map(i -> i.getThisLottoGrade().getPrize())
            .mapToInt(i -> i).sum();
    }

    /**
     * 구매한 모든 로또의 당첨 결과 출력
     * @param wallet
     * @param lottoGrade
     */
    public static void printLottoResult(Wallet wallet, LottoGrade[] lottoGrade) {
        Arrays.stream(lottoGrade).sorted()
            .filter(i -> !i.equals(LottoGrade.NO_GRADE))
            .forEach(i -> {
                printLottoValue(i.getMatchCount(), i.getBonus(), i.getPrize());
                System.out.print("- " + Math.toIntExact(wallet.getLottos().stream()
                    .filter(lotto -> i.getMatchCount() == lotto.getThisLottoGrade().getMatchCount())
                    .count())
                    + "개");
                System.out.println("");
            });
    }

    /**
     * 수익률 출력
     * @param wallet
     * @param budget
     */
    public static void printYieldRate(Wallet wallet, int budget) {
        System.out.println(
            "총 수익률은 " + new DecimalFormat("#.##").format(
                Long.valueOf(getTotalPrize(wallet) / budget))
                + "입니다.(수익률 기준은 1입니다.)");
    }


}
