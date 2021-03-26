package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.service.LottoFactory;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestLottoArgument;
import study.lotto.view.dto.ManualLottoParser;

import java.util.List;

/**
 * 유저와 로또 사이 판매자 역할
 */
public class LottoStore {

    public Lottos issueLotto(final RequestLottoArgument argument, final ManualLottoParser manualLottoParser) {
        return new Lottos(getManualAndAuto(argument.autoSize(), manualLottoParser));
    }

    private List<Lotto> getManualAndAuto(final int totalCount, final ManualLottoParser manualLottoParser) {
        return LottoFactory.createManualAndAuto(totalCount, manualLottoParser);
    }
}
