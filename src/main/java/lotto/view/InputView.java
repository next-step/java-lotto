package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입 급액을 입력해주세요.");
        return scanner.nextInt();
    }

    public int inputNumberOfLottosByHand() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return scanner.nextInt();
    }

    public List<String[]> inputLottosByHand(int numberOfLottosByHand) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        scanner.nextLine();
        List<String[]> inputList = new ArrayList<>();
        for (int i = 0; i < numberOfLottosByHand; i++) {
            String input = scanner.nextLine();
            inputList.add(splitLottoNumbers(input));
        }

        return inputList;
    }

    public String[] inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        String input = scanner.nextLine();
        return splitLottoNumbers(input);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }

    private String[] splitLottoNumbers(String input) {
        return input.replace(" ", "").split("[, ]");
    }
}
