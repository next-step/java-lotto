package step2.view;

public class InputView {

    public void inputMoneyComment() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
    }

    public void confirmComment(int money) {
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.\n");
    }
}
