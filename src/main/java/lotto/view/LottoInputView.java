package lotto.view;

import lotto.dto.Lotto;
import lotto.dto.LottoProfit;
import lotto.dto.LottoWinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInputView {

    public static LottoProfit buyLotto() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int buyAmount = scanner.nextInt();

        if (buyAmount == 0) {
            throw new IllegalArgumentException("돈을 넣으세요.");
        }

        if (buyAmount < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("돈을 더 넣으세요.");
        }

        LottoProfit lottoProfit = new LottoProfit(buyAmount / Lotto.LOTTO_PRICE, buyAmount);

        System.out.println(lottoProfit.getBuyCount() + "개를 구매했습니다.");

        return lottoProfit;
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
     * 보너스 번호 입력
     */
    public static int inputBounusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
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

        if (winningNumbers.length != Lotto.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("당첨숫자 개수 안맞음");
        }

        return winningNumbers;
    }

    /**
     * 문자열 배열로 넘어온 당첨번호 중복체크 후
     * 정수형 리스트로 리턴
     *
     * @param winningNumbers 당첨번호 string[]
     * @param bonusNumber 보너스번호
     * @return 당첨번호 list
     * @throws IllegalArgumentException
     */
    public static LottoWinningNumber createWinningNumbers(String[] winningNumbers, int bonusNumber) throws IllegalArgumentException {

        Set<Integer> duplicateNumbers = Stream.of(winningNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        duplicateNumbers.add(bonusNumber);

        //중복 입력 체크
        if (duplicateNumbers.size() != Lotto.LOTTO_NUM_COUNT + Lotto.LOTTO_BONUS_COUNT) {
            throw new IllegalArgumentException("중복 당첨숫자 있음");
        }

        duplicateNumbers.remove(bonusNumber);

        return new LottoWinningNumber(new ArrayList<>(duplicateNumbers), bonusNumber);
    }
}
