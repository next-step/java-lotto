package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String inputPrice() {
        System.out.println("구매금액을 입력해 주세요.");
        final String price = scanner.nextLine();
        return price;
    }

    public String luckyNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String luckyNumber = scanner.nextLine();
        return luckyNumber;
    }

}
