package step2.view;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import step2.model.Lotto;
import step2.model.LottoNumber;
import step2.util.LottoMakeNumbers;

public class LottoInput {

    private static final String INPUT_MENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_SELF_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_SELF_NUMNBERS = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputGameMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MENT);
        int inputMoney = scanner.nextInt();

        return inputMoney;
    }

    public static LottoNumber inputBonus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_BONUS_NUMBER);
        int inputBonus = scanner.nextInt();

        return LottoNumber.of(inputBonus);
    }

    public static String inputWinnerNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_WIN_NUMBER);
        String inputWinnerNumbers = scanner.nextLine();

        return inputWinnerNumbers;
    }

    public static List<Lotto> inputInputSelfPurchase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_SELF_PURCHASE);
        int inputSelfPurchase = scanner.nextInt();

        System.out.println(INPUT_SELF_NUMNBERS);
        List<String> selfNumbers = inputInputSelfLottoNumbers(inputSelfPurchase);

        Stream<Lotto> lottoConvertor = selfNumbers.stream()
            .map(LottoMakeNumbers::convertStringToNumbers)
            .map(Lotto::of);

        return lottoConvertor.collect(toList());
    }

    private static List<String> inputInputSelfLottoNumbers(int limitCount) {
        Scanner scanner = new Scanner(System.in);

        List<String> SelfLottoNumbers = Stream.generate(scanner::nextLine)
            .limit(limitCount)
            .collect(toList());

        return SelfLottoNumbers;
    }
}