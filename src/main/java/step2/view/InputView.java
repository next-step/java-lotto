package step2.view;

public class InputView {

    public void inputComment() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void confirmComment(int money) {
        int count = money/1000;
        System.out.println(count+"개를 구매했습니다.\n");
    }
}
