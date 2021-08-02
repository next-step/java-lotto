package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.LottoValidate;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int buyLotto() {
        System.out.println("구매할 로또 금액을 입력하세요.");
        return sc.nextInt();
    }

    public int buyManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return sc.nextInt();
    }

    public List<Lotto> manualLottoNumber(int manualCount) {
        List<Lotto> list = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 번호를 입력하세요.");

        for (int i = 0; i < manualCount; i++) {
            Set<Integer> lottoList = new HashSet<>(makeCorrectNumber(sc.next()));
            LottoValidate.duplicateValidate(lottoList);
            list.add(LottoMaker.manual(lottoList));
        }
        return list;
    }

    public List<Integer> lastWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");

        Set<Integer> duplicated = new HashSet<>(makeCorrectNumber(sc.next()));
        LottoValidate.duplicateValidate(duplicated);
        List<Integer> lastLottoResult = new ArrayList<>(duplicated);

        Collections.sort(lastLottoResult);
        return lastLottoResult;
    }

    public int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return sc.nextInt();
    }

    private List<Integer> makeCorrectNumber(String text) {
        return Arrays.stream(text.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}
