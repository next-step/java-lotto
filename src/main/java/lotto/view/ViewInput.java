package lotto.view;

import lotto.model.LottoNumber;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewInput {
    public final static String INPUT_EXPENSE_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String INPUT_NUM_TICKET_MESSAGE = "%s개를 구매했습니다.";
    public final static String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public final static String INPUT_WINNING_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public final static String COMMENT_ASK_NUMBER_OF_MANUAL_LOTTOTICKETS = "수동으로 구매할 로또 수를 입력해 주세요.";
    public final static Integer PRICE_LOTTO_TICKET = 1000;

    public static int askExpense(){
        System.out.println(INPUT_EXPENSE_MESSAGE);
        Scanner scan = new Scanner(System.in);
        return validateExpense(scan.nextInt());
    }

    public static int getAvailableNumLottoTicket(int expense){
        int numLottoTicket = (expense / PRICE_LOTTO_TICKET);
        System.out.println(String.format(INPUT_NUM_TICKET_MESSAGE, numLottoTicket));
        return numLottoTicket;
    }

    public static LottoNumber askBonusNumber(){
        System.out.println(INPUT_WINNING_LOTTO_BONUS_NUMBER);
        Scanner scan = new Scanner(System.in);
        Integer bonusNumber  = scan.nextInt();
        return new LottoNumber(bonusNumber);
    }

    public static List<LottoNumber> askWinningNumbers(){
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().replaceAll("\\s", "").split(",");
        validate(tokens);
        List<LottoNumber> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(new LottoNumber(Integer.parseInt(token)));
        }
        return result;
    }

    private static int validateExpense(int expense){
        try {
            if(expense < PRICE_LOTTO_TICKET){
                throw new Exception("not enough to buy lotto");
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return expense;
    }

    private static void validate(String[] tokens) {
        try {
            if (tokens.length != 6) {
                throw new Exception("lottoNumber consists of 6 number");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static int askNumManualLottoTicket() {
        System.out.println(COMMENT_ASK_NUMBER_OF_MANUAL_LOTTOTICKETS);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
