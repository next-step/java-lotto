package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoApplication {

    
    public static void main(String[] args){
        String purchaseAmount = InputView.requestPurchaseAmount();
        // dto 필요
        // 예외 처리 필요
        int purchaseLottoCount = Integer.parseInt(purchaseAmount) / 1000;
        ResultView.responseLottoCount(purchaseLottoCount);

        // purchaseLottoCount 개 만큼 랜덤으로 1~45까지의 6개 배열 생성

//        String winningNumber = InputView.requestLastWeekWinningNumber();
    }
}
