package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoOrganizer {

    private static final int NO_GRADE_PRIZE = 0;
    private static final int FIFTH_PRIZE = 5000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int FIRST_PRIZE = 2000000000;

    private static final LottoGenerator generator = new LottoGenerator();

    /**
     * 로또 당첨 순위 enum 객체
     */
    public enum LottoGrade {
        NO_GRADE(0, false), // 순위 외
        FIFTH(3, false), // 5등
        FOURTH(4, false), // 4등
        THIRD(5, false), // 3등
        SECOND(5, true), // 2등
        FIRST(6, false); // 1등

        private final int matchCount; // 구매한 로또와 당첨 순위를 비교했을 때, 맞힌 개수
        private final int prize; // 당첨 순위의 상금

        private boolean bouns; // 보너스 볼 당첨 여부

        /**
         * 로또 순위 생성자
         *
         * @param matchCount
         * @param bouns
         */
        LottoGrade(int matchCount, boolean bouns) {
            // 순위 권 외 일 경우, 맞힌 횟수 0으로 포기화
            if (matchCount < 3) {
                matchCount = 0;
            }
            this.matchCount = matchCount;
            this.prize = getPrize(matchCount, bouns);
            this.bouns = bouns;
        }

        /**
         * 당첨 순위에 따른 상금 리턴하는 함수
         *
         * @param matchCount 맞힌 개수
         * @param bouns      보너스 볼 당첨 여부
         * @return
         */
        private int getPrize(int matchCount, boolean bouns) {
            if (matchCount < 3) {
                return NO_GRADE_PRIZE;
            }
            if (matchCount == 3) {
                return FIFTH_PRIZE;
            }
            if (matchCount == 4) {
                return FOURTH_PRIZE;
            }
            if (matchCount == 5 && bouns) {
                return SECOND_PRIZE;
            }
            if (matchCount == 5) {
                return THIRD_PRIZE;
            }
            if (matchCount > 5) {
                return FIRST_PRIZE;
            }
            return NO_GRADE_PRIZE;
        }

        /**
         * 로또 당첨 상태 출력 함수
         */
        private void printLottoValue() {
            if (this.bouns) {
                System.out.print(this.matchCount + "개 일치, 보너스 볼 일치(" + this.prize + ")");
            }
            if (!this.bouns) {
                System.out.print(this.matchCount + "개 일치 (" + this.prize + ")");
            }
        }
    }

    /**
     * 로또 구매 함수
     *
     * @param money 금액
     * @return
     */
    public static List<Lotto> purchase(int money) {
        if (money < 1000) {
            throw new RuntimeException("로또를 구입할 금액이 부족합니다.");
        }
        int count = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generator.generate());
        }

        return lottos;
    }

    /**
     * 구매자의 지갑에 있는 로또의 당첨 순위를 체크하는 함수
     *
     * @param wallet       사용자 지갑
     * @param winnerNumber 당첨 번호
     * @param bonusBall    보너스 볼 번호
     */
    public void allCheckInWallet(Wallet wallet, List<Integer> winnerNumber, int bonusBall) {
        wallet.getLottos().stream()
            .forEach(i -> i.grade = this.checkLotto(i, winnerNumber, bonusBall));
    }

    /**
     * 사용자 지갑의 로또 총 당첨 통계 작업 함수
     *
     * @param wallet 사용자 지갑
     * @param budget 금액
     */
    public void printCustomerLottoResult(Wallet wallet, int budget) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        int income = wallet.getLottos().stream().map(i -> i.getThisLottoGrade().prize)
            .mapToInt(i -> i).sum();
        Arrays.stream(LottoGrade.values()).sorted().filter(i -> !i.equals(LottoGrade.NO_GRADE))
            .forEach(lottoGrade -> {
                lottoGrade.printLottoValue();
                System.out.print("- " + Math.toIntExact(wallet.getLottos().stream()
                    .filter(i -> lottoGrade.matchCount == i.getThisLottoGrade().matchCount).count())
                    + "개");
                System.out.println("");
            });
        System.out.println(
            "총 수익률은 " + new DecimalFormat("#.##").format(Long.valueOf(income / budget))
                + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    /**
     * 사용자 지갑의 로또 한 개에 대한 순위 체크 함수
     *
     * @param lotto        로또 객체
     * @param winnerNumber 당첨 번호
     * @param bonusBall    보너스 볼 번호
     * @return
     */
    public static LottoGrade checkLotto(Lotto lotto, List<Integer> winnerNumber, int bonusBall) {
        int matchCount = Math.toIntExact(
            winnerNumber.stream().filter(integer -> lotto.getLotto().contains(integer)).count());
        if (matchCount < 3) {
            matchCount = 0;
        }
        return getLottoGrade(matchCount, lotto.getLotto().contains(bonusBall));
    }

    /**
     * 로또의 당첨 순위를 반환하는 함수
     *
     * @param customerMatchCount 번호를 맞힌 개수
     * @param hasBonus           보너스 볼 당첨 여부
     * @return
     */
    private static LottoGrade getLottoGrade(int customerMatchCount, boolean hasBonus) {
        return Arrays.stream(LottoGrade.values()).filter(
                lottoGrade -> lottoGrade.matchCount == customerMatchCount
                    && lottoGrade.bouns == hasBonus).findFirst()
            .orElse(LottoGrade.NO_GRADE);
    }
}
