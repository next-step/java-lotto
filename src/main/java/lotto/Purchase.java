package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Purchase {

    private final static int Lotto_Amount = 1000;

    int purchaseAmount;
    LottoNumber bonusBall;
    String inputWinNumber;

    List<LottoNumber> numberList = new ArrayList<>();
    List<LottoNumber> winningNumber = new ArrayList<>();

    String[] inputWinNumberArr = new String[6];

    public Purchase() {

    }

    public void inputPurchaseAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("구입금액 : ");
        this.purchaseAmount = sc.nextInt();
    }

    public void inputWinNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("지난주 당첨번호 : ");
        inputWinNumber = sc.nextLine();
        System.out.print("보너스볼 : ");
        bonusBall = new LottoNumber(sc.nextInt());
        split();
    }

    public void split() {
        inputWinNumberArr = this.inputWinNumber.split(",");
        for (String s:inputWinNumberArr) {
            winningNumber.add(new LottoNumber(Integer.parseInt(s)));
        }
    }

    public List<LottoNumber> createAutoNumber() {
        for (int i = 1; i <= 45; i++) {
            numberList.add(new LottoNumber(i));
        }
        Collections.shuffle(numberList);
        numberList = numberList.subList(0, 6);

        return numberList;
    }

    public List<LottoNumber> getPurchaseNumber() {
        return numberList;
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public void printResult(int[] winCount) {

        System.out.println("당첨 통계");
        System.out.println("-------------------");
        System.out.println("3개 일치 (" + Rank.FIFTH.getPrize() + ")- " + winCount[4] + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getPrize() + ")- " + winCount[3] + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getPrize() + ")- " + winCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize() + ")- " + winCount[1] + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getPrize() + ")- " + winCount[0] + "개");
    }

    public void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
    public void printPurchaseNumber() {
        int cnt = 0;
        System.out.print("[");
        for (LottoNumber i:numberList) {
            System.out.print(i.getNumber());
            if(cnt != 5) {
                System.out.print(", ");
            }
            cnt++;
        }
        System.out.print("]");
        System.out.println();
    }

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / Lotto_Amount;
    }

    public List<LottoNumber> createNumber(final int ... listNumber) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i: listNumber) {
            lottoNumberList.add(new LottoNumber(i));
        }

        return lottoNumberList;
    }
}
