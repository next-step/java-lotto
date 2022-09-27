package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.impl.RandomNumberPicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApp {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            InputView.printMoneyQst();
            Integer money = Integer.parseInt(br.readLine());
            LottoStore lottoStore = new LottoStore(new RandomNumberPicker());
            Lottos lottos = lottoStore.buy(money);

            InputView.printLottoBuyMsg(lottos.getSize());
            OutputView.printLottos(lottos);
            InputView.printWinningNumberQst();
            List<Integer> winningNumber = Arrays.stream(br.readLine().split(",")).map((num) -> Integer.valueOf(num.trim()))
                                          .collect(Collectors.toList());
            Lotto winningLotto = new Lotto(winningNumber);
            lottos.getReward(winningLotto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}