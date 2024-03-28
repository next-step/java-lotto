package lotto.ui;

import lotto.domain.AnswerSheet;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.match.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final static int LOTTO_VALUE = 1000;


    public void startLotto() {
        LottoShop lottoShop = new LottoShop();

        LottoList lottoList = purchaseLotto(lottoShop.inputMoney());
        lottoShop.printPurchaseLotto(lottoList);

        List<Integer> answerNumbers = extractNumber(lottoShop.inputAnswerSheet());
        String bonusNumber = lottoShop.inputBonusNumber();

        LottoResult lottoResult = lottoList.getLottoResult(new AnswerSheet(answerNumbers, bonusNumber));
        lottoShop.printResult(lottoResult,LOTTO_VALUE);
    }

    private List<Integer> extractNumber(String inputNumbers) {
        List<Integer> collect = Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        if(collect.size() != Lotto.LOTTO_NUMBER_LIMIT)
            throw new IllegalArgumentException("숫자는 6개이여야합니다.");
        return collect;
    }

    private LottoList purchaseLotto(String requestMoney) {
        int count = Integer.parseInt(requestMoney) / LOTTO_VALUE;
        return new LottoList(count);
    }
}
