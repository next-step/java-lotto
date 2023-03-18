package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoView {

    private final Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int insertMoney() {
        System.out.println("로또를 구입할 금액을 입력하세요.(로또 가격은 1,000원입니다.)");
        return this.scanner.nextInt();
    }

    public List<Integer> insertWinningLottoNumbers() {
        System.out.println("로또 당첨 번호를 입력하세요.");
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < Lotto.LOTTO_BALL_COUNT){
            numbers.add(this.scanner.nextInt());
        }
        return numbers;
    }

    public int insertBonusBallNumbers() {
        System.out.println("보너스 번호를 입력하세요.");
        return this.scanner.nextInt();
    }

    public void printLottoGrade(LottoGrades.LottoGrade grade, int matchCount) {
        if(grade == LottoGrades.LottoGrade.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d%n", grade.getMatchCount(), grade.getPrizeMoney() * matchCount, matchCount);
            return;
        }

        System.out.printf("%d개 일치 - %d%n", grade.getMatchCount(), grade.getPrizeMoney() * matchCount, matchCount);
    }

    public void printStatistics() {
        String message = "당첨 통계" +
                "\n----------";

        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.stream().count());
        lottos.stream().forEach(lotto -> {
            this.printLotto(lotto);
        });
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printTotalEarningRate(double earningRate) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", earningRate));
    }
}
