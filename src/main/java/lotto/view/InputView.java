package lotto.view;

import lotto.domain.*;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;
    private static final String regex = "([0-9]+)";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int buyingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateInt(scanner.nextLine());
    }

    public int manualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return validateInt(scanner.nextLine());
    }

    public Lottos getManualLottoInput(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>(manualLottoCount);

        for (int i = 0; i < manualLottoCount; i++) {
            Lotto manualLotto = stringToLotto(scanner.nextLine());
            lottoList.add(manualLotto);
        }
        return new Lottos(lottoList);
    }

    public String getWinningNoInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public Lotto stringToLotto(String input) {
        String[] winningNoStrArr = split(input);

        return new Lotto(Arrays.stream(winningNoStrArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet()));
    }

    public WinningLotto bonusNumber(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new WinningLotto(winningLotto, new LottoNumber(validateInt(scanner.nextLine())));
    }

    public int validateInt(String input) {
        checkBlank(input);
        if(!Pattern.matches(regex, input)){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return Integer.parseInt(input);
    }

    public String[] split(String input) {
        checkBlank(input);
        return input.split(", ");
    }

    public void checkBlank(String input){
        Optional.ofNullable(input)
                .filter(s -> !s.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("값이 없습니다."));
    }
}
