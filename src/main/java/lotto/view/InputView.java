package lotto.view;

public class InputView {
    private int count = 0;

    public void buyLotto(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("로또는 천원단위로 구매가 가능합니다");
        }

        count = price / 1000;
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lastWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");

    }
}
