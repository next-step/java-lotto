package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    public int inputPurchasePrice() {
        System.out.println("구매 금액을 입력해주세요");
        return new Scanner(System.in).nextInt();
    }

    public Lotto inputWinningLottoNumbers() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winngLottoNumbers = new Scanner(System.in).nextLine();

         return new Lotto(Arrays.stream(winngLottoNumbers.split(","))
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
