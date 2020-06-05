package lotto_step2.view;

import com.google.common.base.Splitter;
import lotto_step2.model.Lotto;
import lotto_step2.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto_step2.LottoConstants.*;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = scanner.nextInt();
        checkMoney(money);

        return money;
    }

    public void printBuyLotto(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");

        for (Lotto lotto: lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public Lotto getLastWeekLotto() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.nextLine();

        List<String> splitValues = Splitter.on(',').splitToList(inputValue);
        return new Lotto(getIntSplitValues(splitValues));
    }

    private List<Integer> getIntSplitValues(List<String> splitValues) {

        List<Integer> intSplitValues = new ArrayList<>();

        for(String splitValue : splitValues) {
            checkSplitValue(Integer.parseInt(splitValue));
            intSplitValues.add(Integer.parseInt(splitValue));
        }
        checkIntSplitValues(intSplitValues);
        return intSplitValues;
    }

    public void checkSplitValue(int splitValue) {
        if (splitValue < LOTTO_MIN_VALUE || splitValue > LOTTO_LIMIT_NUMBER) {
            throw new IllegalArgumentException("입력된 번호가 범위를 벗어났습니다.");
        }
    }

    public void checkMoney(int money) {
        if (money < LOTTO_PER_PRICE) {
            throw new IllegalArgumentException("구매 금액이 1,000원 이하입니다.");
        }
    }

    public void checkIntSplitValues(List<Integer> intSplitValues) {
        List<Integer> checkList = intSplitValues.stream()
                .distinct()
                .collect(Collectors.toList());

        if (!(checkList.size() == LOTTO_LIMIT_SIZE)) {
            throw new IllegalArgumentException("지난 주 당첨 번호 입력 오류 발생");
        }
    }
}
