package step2.view;

import step2.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static int purchasedAmount;
    private static int numberOfLottoTickets;
    private static String[] givenWinningNumbers;

    public static void inputPayments(){
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        purchasedAmount = scan.nextInt();
        numberOfLottoTickets = purchasedAmount / LottoTicket.LOTTO_PRICE;
    }

    public static void inputWinningNumberS(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n지난주 방첨 번호를 입력해주세요.");
        String winningNumbersInput = scan.nextLine();
        givenWinningNumbers = winningNumbersInput.split(",");
        for (int i = 0; i < givenWinningNumbers.length; i++) {
            givenWinningNumbers[i] = givenWinningNumbers[i].trim();
        }
    }

    public static List<Integer> getWinningNumbers(){
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < givenWinningNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(givenWinningNumbers[i]));
        }
        return winningNumbers;
    }

    public static int getNumberOfLottoTickets(){
        return numberOfLottoTickets;
    }
}
