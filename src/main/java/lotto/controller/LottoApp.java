package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lottos;
import lotto.service.impl.RandomNumberPicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoApp {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            InputView.printMoneyQst();
            Integer money = Integer.parseInt(br.readLine());
            LottoStore lottoStore = new LottoStore(new RandomNumberPicker());
            Lottos lottos = lottoStore.buy(money);

            InputView.printLottoBuyMsg(lottos.getSize());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}