package ui;

import domain.Lotto.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;

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
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 문자열 입니다.");
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
        String input = sc.next(); // 예: 1,2,3,4,5,6
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        return new LottoTicket(numbers);
    }

    public int getBonusTicket() {
        System.out.println("Please enter Bonus number.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int getManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<LottoTicket> getManualTickets(int manualTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        List<LottoTicket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            String input = sc.nextLine(); // 예: "8, 21, 23, 41, 42, 43"
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            manualTickets.add(new LottoTicket(numbers));
        }
        return manualTickets;
    }
}

