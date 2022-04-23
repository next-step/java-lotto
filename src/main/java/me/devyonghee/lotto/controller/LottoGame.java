package me.devyonghee.lotto.controller;

import me.devyonghee.lotto.model.LottoStore;
import me.devyonghee.lotto.model.LottoTickets;
import me.devyonghee.lotto.model.RandomGenerator;
import me.devyonghee.lotto.view.InputView;
import me.devyonghee.lotto.view.ResultView;
import me.devyonghee.lotto.view.dto.LottoTicketsResponse;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public final class LottoGame {

    private static final String NULL_INPUT_STREAM_ERROR_MESSAGE = "inputStream must not be null";
    private static final String NULL_OUTPUT_ERROR_MESSAGE = "output must not be null";
    private final InputView inputView;
    private final ResultView resultView;

    private LottoGame(InputStream inputStream, PrintStream output) {
        Objects.requireNonNull(inputStream, NULL_INPUT_STREAM_ERROR_MESSAGE);
        Objects.requireNonNull(output, NULL_OUTPUT_ERROR_MESSAGE);
        this.inputView = InputView.of(new Scanner(inputStream), output);
        this.resultView = ResultView.from(output);
    }

    public static LottoGame of(InputStream inputStream, PrintStream output) {
        return new LottoGame(inputStream, output);
    }

    public void start() {
        LottoTickets tickets = LottoStore.of(inputView.purchaseAmount(), RandomGenerator.getInstance()).lottoTickets();
        resultView.printTickets(LottoTicketsResponse.from(tickets));
        inputView.winnerNumbers();

    }

}
