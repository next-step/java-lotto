package lotto;

import java.util.Scanner;

public class NumberInputScanner {

    private int number;

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.number = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자를 입력해 주세요");
        }
    }

    public int getNumber() {
        getInputStream();
        return number;
    }
}
