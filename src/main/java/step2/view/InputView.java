package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private final String SPLIT_SIGN = ",";

    public int askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Integer> askWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        List<Integer> winnerLottoNumber = new ArrayList<>();
        setWinnerLottoNumber(winnerLottoNumber);
        return winnerLottoNumber;
    }

    private void setWinnerLottoNumber(List<Integer> winnerLottoNumber) {
        String[] splitString = split(scanner.nextLine());
        for (int i = 0; i < splitString.length; i++) {
            int winnerNumber = validateWinnerNumber(splitString[i]);
            winnerLottoNumber.add(winnerNumber);
        }
    }

    private int validateWinnerNumber(String splitString) {
        int winnerNumber = Integer.parseInt(splitString);
        if (winnerNumber > 45 || winnerNumber < 1) {
            throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
        }
        return winnerNumber;
    }

    private String[] split(String nextLine) {
        String[] splitString = nextLine.split(SPLIT_SIGN);
        if (splitString.length != 6) {
            throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
        }
        return splitString;
    }
}
