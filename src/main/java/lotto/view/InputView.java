package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;

    private int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        validPrice(price);
        return price;
    }

    public int getLottoCount() {
        int count = inputPrice() / LOTTO_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public String inputLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public void validPrice(int price) {
        if(price < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 1000원 입니다");
        }
    }
}
