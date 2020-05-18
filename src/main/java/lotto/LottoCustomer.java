package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoMatch;
import lotto.domain.LottoNum;
import lotto.domain.LottoNums;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCustomer {

    public static void main(String[] args){
        int price = InputView.requestPrice();

        LottoSeller lottoSeller = new LottoSeller();
        Lottos lottos = lottoSeller.sell(price);

        OutputView.printLottos(lottos.getLottos());

        List<Integer> winNums =  InputView.requestNums();

        LottoNums lottoNums = new LottoNums(
            winNums.stream().map(integer -> new LottoNum(integer)).collect(
                Collectors.toList())
        );

        OutputView.printLottoResult(lottos.getResult(lottoNums, price));
    }

}
