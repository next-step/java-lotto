package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public int getMoney(){
        int money = 0;

        System.out.println("로또를 구매할 금액을 입력해주세요");
        
        money = sc.nextInt();

        return  money;
    }

    public int[] getWinningNumbers(){
        int[] winningNumbers = new int[6];
        String winningNumber = "";

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        winningNumber = sc.nextLine();
        winningNumbers = convertWinningNumbers(winningNumber);

        return winningNumbers;
    }

    public int[] convertWinningNumbers(String values){
        String[] value = values.split(",");
        int[] numbers = Arrays.stream(value).mapToInt(Integer::parseInt).toArray();
        return numbers;
    }
}
