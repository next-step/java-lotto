package lotto.view;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoInputView {
    private static final int LOTTO_NUM_COUNT = 6;

    public static int buyLotto() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int number = scanner.nextInt();

        if (number == 0) {
            throw new IllegalArgumentException("돈을 넣으세요.");
        }

        if (number < 1000) {
            throw new IllegalArgumentException("돈을 더 넣으세요.");
        }

        System.out.println(number/1000 + "개를 구매했습니다.");

        return number/1000;
    }

    /**
     * 지난주 당첨번호 입력
     */
    public static String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    /**
     * 당첨번호 예외 체크
     */
    public static String[] splitWinningNumbers(String inputValue) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^([0-9]+,\\s)+[0-9]+$");
        Matcher matcher = pattern.matcher(inputValue.trim());
        if (!matcher.find()) {
            throw new IllegalArgumentException("패턴 불일치");
        }

        String[] winningNumbers = inputValue.split(", ");

        if (winningNumbers.length != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("당첨숫자 개수 안맞음");
        }

        return winningNumbers;
    }

    /**
     * 문자열 배열로 넘어온 당첨번호 중복체크 후
     * 정수형 리스트로 리턴
     *
     * @param winningNumbers 당첨번호 string[]
     * @return 당첨번호 list
     * @throws IllegalArgumentException
     */
    public static List<Integer> createWinningNumbers(String[] winningNumbers) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(winningNumbers).forEach(number -> numbers.add(Integer.valueOf(number)));

        //중복 입력 체크
        Set<Integer> duplicateNumbers = new HashSet<>(numbers);
        if (duplicateNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("중복 당첨숫자 있음");
        }

        return numbers;
    }
}
