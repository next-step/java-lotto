package lotto.view;

import lotto.constant.Question;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.util.LottoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);


    public int priceScan() {
        System.out.println(Question.PRICE.getQuestion());
        return scanner.nextInt();
    }

    public int manualCountScan() {
        System.out.println(Question.MANUAL_COUNT.getQuestion());
        return scanner.nextInt();
    }

    public List<LottoNumbers> manualNumberScan(LottoCount manualCount) {
        scanner.nextLine();
        System.out.println(Question.MANUAL_NUMBER.getQuestion());
        List<LottoNumbers> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount.getManualLottoCount(); i++) {
            manualNumbers.add(new LottoNumbers(LottoUtil.CastingArrayToList(scanner.nextLine().split(","))));
        }
        return manualNumbers;
    }

    public String[] lastWeekLottoNumbersScan() {
        System.out.println(Question.LAST_WEEK_LOTTO_NUMBER.getQuestion());
        return scanner.nextLine().split(",");
    }

    public int bonusNumberScan() {
        System.out.println(Question.BONUS_NUMBER.getQuestion());
        return scanner.nextInt();
    }
}
