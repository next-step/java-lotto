package lotto.view;

import calculator.PositiveNumber;
import lotto.domain.Credit;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WonLotto;
import lotto.dto.LottoDto;
import lotto.dto.WonLottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author han
 */
public class InputView {
    private static final String INSERT_PURCHASE_PRICE = "구입금액을 입력해주세요";
    private static final String INSERT_LAST_WON_LOTTO = "지난 주 당첨 번호를 입력해주세요";
    private static final String INSERT_BONUS_NUMBER = "보너스 볼을 입력해주세요";
    private static final String INSERT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INSERT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Credit getCredit() {
        System.out.println(INSERT_PURCHASE_PRICE);
        String line = scanner.nextLine();
        return new Credit(line);
    }

    public PositiveNumber getManualLottoCount() {
        System.out.println(INSERT_MANUAL_LOTTO_COUNT);
        String line = scanner.nextLine();
        return new PositiveNumber(line);
    }

    public List<LottoDto> insertManualLotto(PositiveNumber manualLottoCount) {
        System.out.println(INSERT_MANUAL_LOTTO_NUMBER);
        return createByString(manualLottoCount.getNumber());
    }

    public WonLottoDto insertWonLotto() {
        System.out.println(INSERT_LAST_WON_LOTTO);
        String wonNumbers = scanner.nextLine();

        System.out.println(INSERT_BONUS_NUMBER);
        String bonusNumber = scanner.nextLine();
        return new WonLottoDto(wonNumbers, bonusNumber);
    }

    private List<LottoDto> createByString(int number) {
        List<LottoDto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String lottoString = scanner.nextLine();
            lottos.add(new LottoDto(lottoString));
        }

        return lottos;
    }
}
