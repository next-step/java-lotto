package step2.view;

import static step2.view.Messages.REQUEST_BONUS_NUMBER;
import static step2.view.Messages.REQUEST_LAST_WEEK_WINNING_NUMBER;
import static step2.view.Messages.REQUEST_MANUAL_COUNT;
import static step2.view.Messages.REQUEST_MANUAL_LOTTOS;
import static step2.view.Messages.REQUEST_PRICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step2.domain.LottoSheet;
import step2.domain.UserLotto;
import step2.util.Utils;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputPrice() {
        System.out.println(REQUEST_PRICE);
        return Integer.valueOf(scanner.nextLine());
    }

    public List<Integer> inputLastWeekWinningNumbers() {
        System.out.println(REQUEST_LAST_WEEK_WINNING_NUMBER);
        return Utils.convertStringToIntegerList(Utils.convertCsvStringToList(scanner.nextLine()));
    }

    public int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Integer.valueOf(scanner.nextLine());
    }

    public int inputManualLottoCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        return Integer.valueOf(scanner.nextLine());
    }

    public LottoSheet inputManualLotto(int count) {
        System.out.println(REQUEST_MANUAL_LOTTOS);
        List<UserLotto> result = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            result.add(new UserLotto(Utils.convertStringToIntegerList(Utils.convertCsvStringToList(scanner.nextLine()))));
        }
        return new LottoSheet(result);
    }
}
