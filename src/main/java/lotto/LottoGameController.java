package lotto;

import lotto.domain.SeedMoney;
import lotto.view.InputView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-11-19.
 */
public class LottoGameController {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        SeedMoney seedMoney = InputView.askAndShowLottoGameMoney();

    }
}
