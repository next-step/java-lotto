package me.namuhuchutong.lotto.controller;

import me.namuhuchutong.lotto.domain.LottoSeller;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.LottoResult;
import me.namuhuchutong.lotto.dto.UserInputInformation;
import me.namuhuchutong.lotto.ui.InputView;
import me.namuhuchutong.lotto.ui.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        UserInputInformation inputInformation = new UserInputInformation(
                inputView.inputAmount(), inputView.inputManualLotto(), inputView.inputNumbers(), inputView.inputBonusNumber());
        LottoSeller lottoSeller = new LottoSeller(numberGenerator);
        LottoResult lottoResult = lottoSeller.sellLotto(inputInformation);
        outputView.showGeneratedLotto(lottoResult);
        outputView.showLottoResult(inputInformation.getAmount(), lottoResult);
    }
}
