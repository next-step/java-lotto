package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String PRE_WEEK_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static int readMoney(){
        System.out.println(MONEY_INPUT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoTicket readPreWeekWinningLottoNums() {
        System.out.println(PRE_WEEK_WINNING_LOTTO_NUMBERS);

        String string = scanner.nextLine().replace(" ", "");
        String[] stringList = string.split(",");

         List<LottoNumber> lottoNumbers = Arrays.stream(stringList)
                 .map(Integer::parseInt)
                 .map(LottoNumber::getLottoNumber)
                 .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }

    public static LottoNumber readLottoNumber(){
        System.out.println(BONUS_BALL);
        int n = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(n);
    }
}
