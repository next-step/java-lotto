package view;

import java.util.Scanner;

public class InputVeiw {
    private final static int MINIMUM_PRICE = 1000;
    private final static int ONE_UNIT_OF_LOTTO = 6;

    private enum Sperator {
        REST(","), BLANK(" "), NOTHING("");

        private String value;

        private Sperator(String input) {
            value = input;
        }

        public String getValue() {
            return value;
        }
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (checkPrice(price)) {
            throw new IllegalArgumentException("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 가격을 다시 한번 입력해주세요.");
        }
        return price;
    }

    private static boolean checkPrice(int price) {
        return price < MINIMUM_PRICE;
    }

    public static int[] inputPrvLottoNumber() {
        Scanner scanner = new Scanner(System.in);
        int[] inputNumber = new int[ONE_UNIT_OF_LOTTO];

        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String input = scanner.nextLine();
        String[] result = removeBlankAndSplit(input);

        if (checkPrvStr(result)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 지난 당첨 번호를 다시 한번 입력해주세요.");
        }

        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            inputNumber[i] = Integer.parseInt(result[i]);
        }
        return inputNumber;
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int bonusBall= scanner.nextInt();
        return bonusBall;
    }

    // 입력받은 지난 당첨번호가 6자리인지 확인
    private static boolean checkPrvStr(String[] input) {
        return input.length != ONE_UNIT_OF_LOTTO;
    }

    public static String[] removeBlankAndSplit(String input) {
        return input.replaceAll(Sperator.BLANK.getValue(), Sperator.NOTHING.getValue()).split(Sperator.REST.getValue());
    }
}
