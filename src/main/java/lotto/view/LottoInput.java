package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_BUYPRICE_MESSAGE = "구입금액을 입력해주세요";
    private static final String INPUT_WINNINTNUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요";
    private static final String INPUT_BONUSBALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String INPUT_MANUAL_PURCHASE_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INPUT_MANUL_PURCHASE_NUMBER = "수동으로 구매할 번호를 입력 해주세요.";

    private LottoInput() {
    }

    public static int inputPrice() {
        System.out.println(INPUT_BUYPRICE_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int inputManualBuyCount() {
        System.out.println(INPUT_MANUAL_PURCHASE_COUNT);
        return SCANNER.nextInt();
    }

    public static Lottos inputManualLottos(int size) {
        System.out.println(INPUT_MANUL_PURCHASE_NUMBER);
        List<Lotto> lottoInput = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoInput.add(convertInputToLotto(SCANNER.next()));
        }
        return new Lottos(lottoInput);
    }

    public static Lotto inputWinningNumber() {
        System.out.println(INPUT_WINNINTNUMBER_MESSAGE);
        String input = SCANNER.next();
        return convertInputToLotto(input);
    }

    public static LottoNumber inputBonusBall() {
        System.out.println(INPUT_BONUSBALL_MESSAGE);
        int bonusBall = SCANNER.nextInt();
        return LottoNumber.from(bonusBall);
    }

    private static Lotto convertInputToLotto(String lottoInput) {
        return Lotto.of(Arrays.stream(lottoInput.split(COMMA))
            .mapToInt(Integer::new)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList()));
    }
}
