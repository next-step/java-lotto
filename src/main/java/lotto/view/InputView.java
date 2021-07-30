package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final int MAX_LENGTH = 6;
    private final Scanner sc = new Scanner(System.in);


    public int buyLotto() {
        System.out.println("구매할 로또 금액을 입력하세요.");
        return sc.nextInt();
    }

    public List<Integer> lastWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        List<Integer> lastLottos = makeCorrectNumber(sc.next());
        Set<Integer> duplicated = new HashSet<>(lastLottos);

        if(duplicated.size() != MAX_LENGTH) {
            throw new IllegalArgumentException("당첨 번호는 중복이 될 수 없습니다.");
        }

        List<Integer> lastLottoResult = new ArrayList<>(duplicated);

        Collections.sort(lastLottoResult);
        return lastLottos;
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
