package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.view.LottoView;

import java.util.Map;

public class LottoMachine {

    private static int LOTTO_PRICE = 1000;

    private final LottoView lottoView;
    private LottoNumbers lottoNumbers;
    private Money money;

    public LottoMachine(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        try {
            createLottoNumbers();
            findWinningLotto();
        } catch (NumberFormatException exception) {
            lottoView.showConvertNumberError();
        } catch (IllegalArgumentException exception) {
            lottoView.showErrorMessage(exception.getMessage());
        }
    }

    private void createLottoNumbers() {
        money = new Money(lottoView.getMoney());
        int lottoCount = getLottoCount(money.get());
        lottoNumbers = new LottoNumbers(lottoCount);

        lottoView.showLottoNumbers(lottoNumbers);
    }

    // 테스트를 위해서 private 메소드의 접근제한자를 바꾸는 것이 옳을까?
    private int getLottoCount(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return money / LOTTO_PRICE;
    }

    private void findWinningLotto() {
        LottoNumber winningLottoNumber = new LottoNumber(lottoView.getWinningLottoNumbers());
        checkWinningLottoNumber(winningLottoNumber);
    }

    private void checkWinningLottoNumber(LottoNumber winningNumber) {
        Map<LottoRank, Long> rankGroup = lottoNumbers.getRankGroup(winningNumber);
        lottoView.showRankResult(rankGroup);
        lottoView.showProfitRate(money.getProfitRate(rankGroup));
    }
}
