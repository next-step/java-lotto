package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String PRE_WEEK_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO__CNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO__NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int readMoney(){
        System.out.println(MONEY_INPUT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoTicket readPreWeekWinningLottoNums() {
        System.out.println(PRE_WEEK_WINNING_LOTTO_NUMBERS);

        String string = scanner.nextLine().replace(" ", "");
        String[] nums = string.split(",");
        return new LottoTicket(nums);
    }

    public static LottoNumber readLottoNumber(){
        System.out.println(BONUS_BALL);
        int n = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(n);
    }

    public static List<LottoTicket>  readManualLottoNumbers(int cnt){
        System.out.println(MANUAL_LOTTO__NUMBERS);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            String string = scanner.nextLine().replace(" ", "");
            String[] nums = string.split(",");
            LottoTicket lottoTicket = new LottoTicket(nums);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public static int readManualLottoCnt(){
        System.out.println(MANUAL_LOTTO__CNT);
        return Integer.parseInt(scanner.nextLine());
    }
}
