package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public int inputDataMoney() {
        System.out.println("구입금액을 입력해 주세요.(1,000원 단위)");
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<Integer> inputDataWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        sc = new Scanner(System.in);
        String[] inputNumbers = sc.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length; i++) {
            int num = Integer.parseInt(inputNumbers[i]);
            numbers.add(num);
        }
        return numbers;
    }


}
