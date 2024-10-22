package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static String INPUT_MSG = "구매금액을 입력해 주세요";
    private final static String INPUT_MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 번호 수를 입력해 주세요";

    public static LottoCount inputBuyDetails() {
        OutputView.printMsg(INPUT_MSG);
        int inputAmount = InputView.inputNumber();

        OutputView.printMsg(INPUT_MANUAL_LOTTO_COUNT_MSG);
        int manualCount = InputView.inputNumber();

        return new LottoCount(inputAmount, manualCount);
    }


    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] inputWinningNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        return Arrays.stream(scanner.nextLine().replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<LottoNumbers> inputManualLottoNumbers(int count) {
        List<LottoNumbers> inputedNumber = new ArrayList<LottoNumbers>();
        for (int i = 0; i < count; i++) {
            inputedNumber.add(createLottoNumber());
        }
        return inputedNumber;
    }

    public static LottoNumbers createLottoNumber() {
        Scanner scanner = new Scanner(System.in);
        try {
            return new LottoNumbers(scanner.next().split(","));
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            System.out.println("로또 번호를 다시 입력하십시오");
            return createLottoNumber();
        }
    }
}
