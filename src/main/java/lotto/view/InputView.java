package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static LottoPrice inputBuyPrice() {
        return new LottoPrice(scanner.nextInt());
    }

    public static void printLottoCount(LottoPrice lottoPrice){
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoPrice.getTicketCount()));
    }

    public static void printBuyLotto(List<LottoNumber> lottoNumbers){
        lottoNumbers.stream().forEach(System.out::println);
    }

    public static void printResultLottoNumber(){
        System.out.println(RESULT_LOTTO_MESSAGE);
    }
    
    public static LottoNumber inputResultLottoNumber(){
        scanner.nextLine();
        return new LottoNumber(StringToIntegerArray(scanner.nextLine()));
    }

    private static Integer[] StringToIntegerArray(String input) {
        return Arrays.stream(splitString(input)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static String[] splitString(String input) {
        return input.replaceAll(" ", "").split(",");
    }
}
