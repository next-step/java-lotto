package ui;

import domain.Lotto.LottoNo;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_MESSAGE = "Please input string:";

    public String[] readAndSplitInput(String input) {
        return splitString(input);
    }

    public String getInput() {
        System.out.println(INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    public void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("The input value is null or an empty string.");
        }
    }

    public String[] splitString(String input) {
        return input.trim()
                .split("\\s+");
    }

    public int getPurchaseAmount() {
        System.out.println("Please enter the purchase amount.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public LottoTicket getWinningTicket() {
        System.out.println("Please enter last week's winning number.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // 예: 1,2,3,4,5,6

        List<LottoNo> lottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers); // validate = true by default
    }

    public LottoNo getBonusTicket() {
        System.out.println("Please enter Bonus number.");
        Scanner sc = new Scanner(System.in);
        int bonus = Integer.parseInt(sc.nextLine());
        LottoNo bonusNumber = new LottoNo(bonus);
        return bonusNumber;

    }

    public int getManualTicketCount() {
        System.out.println("Please enter the number of lottoes to purchase manually.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<List<Integer>> getManualLottoNumbers(int manualTicketCount) {
        System.out.println("Please enter the number you want to purchase manually.");
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> manualNumbers = new ArrayList<>();

        for (int i = 0; i < manualTicketCount; i++) {
            String line = scanner.nextLine();
            List<Integer> numbers = Stream.of(line.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (numbers.size() != 6) {
                throw new IllegalArgumentException("The lotto number should be six.");
            }
            manualNumbers.add(numbers);
        }

        return manualNumbers;
    }

    public WinningLotto getWinningLotto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter last week's winning number.");
        String input = scanner.nextLine();
        List<LottoNo> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("The lotto number should be six.");
        }

        LottoNo bonusNumber = getBonusTicket();

        return new WinningLotto(new LottoTicket(winningNumbers,true), bonusNumber);
    }
}

