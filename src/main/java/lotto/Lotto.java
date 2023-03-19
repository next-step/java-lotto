package lotto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    private static final String DELIMITER = ", ";
    private static final int LOTTO_PRICE = 1000;
    private static int LOTTO_PURCHASE_PRICE;

    public void startLotto() {

        System.out.println("구매금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        LOTTO_PURCHASE_PRICE = sc.nextInt();

        //1.로또구매
        int lottoCount = getLottoCount(LOTTO_PURCHASE_PRICE);
        System.out.println(lottoCount + "개를 구매했습니다.");

        //2.로또티켓생성
        List<List<Integer>> lottoNumberList = getLottoNumberList(lottoCount);

        //3.로또 당첨번호 생성
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numberArr = makeNumberList(input);
        List<Integer> winnerNumbers = getWinnerNumbers(numberArr);
        lottoNumberList.forEach(System.out::println);

        //4.보너스 번호 생성
        int bonusNumber = setBonusNumber();

        //5.당첨확인
        winnerCheck(lottoNumberList, winnerNumbers, bonusNumber);

        //6.당첨출력
        System.out.println("\n당첨 통계");
        System.out.println("-----------");
        Long totalPrize = getTotalPrize();
        System.out.println("총 수익률은 " + getEarningsRate(totalPrize) + "입니다.(기준이 1이기 때문에 1이상은 이익, 1이하는 손실임)");
    }

    private String[] makeNumberList(String input) {
        return input.split(DELIMITER);
    }

    private double getEarningsRate(Long totalPrize) {
        double result = (double) (totalPrize / (double) LOTTO_PURCHASE_PRICE);
        return Math.round(result * 100) / 100.0;
    }

    @NotNull
    public List<List<Integer>> getLottoNumberList(int lottoCount) {
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumberList.add(new LottoTicket().makeLottoNumbers());
        }

        return lottoNumberList;
    }

    public int getLottoCount(int purchaseAmount) {
        if (purchaseAmount < 1000) throw new IllegalStateException("금액부족!!로또는 1장당 1000원입니다.");
        return purchaseAmount / LOTTO_PRICE;
    }

    private int setBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<Integer> getWinnerNumbers(String[] numberArr) {
        return new WinnerNumber(numberArr).getWinnerNumberList();
    }

    public void winnerCheck(List<List<Integer>> lottoNumberList, List<Integer> winnerNumbers, int bonusNumber) {
        for (List<Integer> lottoNumber : lottoNumberList) {
            int count = (int) lottoNumber.stream().filter(it -> winnerNumbers.contains(it)).count();
            setWinnerCount(bonusNumber, lottoNumber, count);
        }
    }

    private void setWinnerCount(int bonusNumber, List<Integer> lottoNumber, int count) {
        switch (count) {
            case 6:
                Winner.FIRST.setWinnerCount();
            case 5:
                if (lottoNumber.contains(bonusNumber)) Winner.SECOND.setWinnerCount();
                else Winner.THIRD.setWinnerCount();
                break;
            case 4:
                Winner.FOURTH.setWinnerCount();
                break;
            case 3:
                Winner.FIFTH.setWinnerCount();
                break;
            default:
                break;
        }
    }

    private Long getTotalPrize() {
        Winner[] counts = Winner.values();
        Long totalPrize = 0L;
        for (Winner winner : counts) {
            System.out.println(printResult(winner));
            if (winner.getWinnerCount() > 0) totalPrize += winner.getPrize() * winner.getWinnerCount();
        }
        return totalPrize;
    }

    private String printResult(Winner winner) {
        if (winner.isBonus())
            return winner.getMatchCount() + "개 일치, 보너스 볼 일치 (" + winner.getPrize() + "원)-" + winner.getWinnerCount() + "개";

        return winner.getMatchCount() + "개 일치 (" + winner.getPrize() + "원)-" + winner.getWinnerCount() + "개";
    }
}
