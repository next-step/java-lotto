package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

        private InputView() {
        }

        private static Scanner scanner = new Scanner(System.in);

        public static long inputAmount() {
                System.out.println("구입금액을 입력해 주세요.");
                return Long.parseLong(scanner.nextLine());
        }

        public static int inputCountOfManualNumberTicket() {
                System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
                return Integer.parseInt(scanner.nextLine());
        }

        public static List<String> inputManualNumbers(int countOfManualTickets) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("수동으로 구매할 번호를 입력해 주세요.");
                List<String> manualTickets = new ArrayList<>();
                String manualNumberInOneLine;
                for (int i = 0; i < countOfManualTickets * 2; i++) {
                        manualNumberInOneLine = scanner.nextLine();
                        addManualNumberLineIntoTheManualTickets(manualNumberInOneLine, manualTickets);
                }
                return manualTickets;
        }

        public static String inputWinningNumberText() {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                return scanner.nextLine();
        }

        public static int inputBonusNumberText() {
                System.out.println("보너스 볼을 입력해 주세요.");
                return Integer.parseInt(scanner.nextLine());
        }

        private static void addManualNumberLineIntoTheManualTickets(String manualNumberInOneLine,
            List<String> manualTickets) {
                if (!manualNumberInOneLine.isBlank()) {
                        manualTickets.add(manualNumberInOneLine);
                }
        }
}
