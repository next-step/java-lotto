package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    private static InputView INSTANCE = null;

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public int getLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public String getLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public LottoNum getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNum(SCANNER.nextInt());
    }

    public int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public Lotto getManualLotto() {
        return getLottoNumbers(SCANNER.nextLine());
    }

    public Lottos getManualLottos() {
        int count = getManualLottoCount();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        clearBuffer();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(getManualLotto());
        }
        return new Lottos(lottos);
    }


    public Lotto getLottoNumbers(String lottoNumbers) {
        List<String> lotto = parseWinnerLotto(lottoNumbers);
        List<LottoNum> lastWinnerLotto = lotto.stream()
                .map(this::parseNumber)
                .collect(Collectors.toList());
        return getLotto(lastWinnerLotto);
    }

    public Lotto getLotto(List<LottoNum> lastWinnerLotto) {
        return new Lotto(lastWinnerLotto);
    }

    private LottoNum parseNumber(String lottoNumber) {
        try {
            return new LottoNum(Integer.parseInt(lottoNumber));
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("숫자 형식이 올바르지 않습니다.");
        }
    }

    private List<String> parseWinnerLotto(String lastWinnerLotto) {
        String text = lastWinnerLotto.replaceAll(" ", "");
        return List.of(text.split(","));
    }

    private void clearBuffer() {
        SCANNER.nextLine();
    }
}
