package lotto.output;

public class LottoOutput {

    public void printAskPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printAmount(final int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printAskWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printAskBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

}
