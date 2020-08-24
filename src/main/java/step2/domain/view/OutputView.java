package step2.domain.view;

import step2.domain.Lotto;
import step2.domain.LottoNumber;

import java.util.stream.Collectors;

public class OutputView {

    public void viewLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoList().size() + "개를 구매했습니다.");
        lotto.getLottoList().stream()
                .map(LottoNumber::getLottoNumbers)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
