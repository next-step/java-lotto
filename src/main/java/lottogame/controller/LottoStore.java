package lottogame.controller;

import static lottogame.model.lotto.LottoMachine.PER_LOTTO_PRICE;
import static lottogame.view.Casher.askLottoNums;
import static lottogame.view.Casher.askBonusNum;
import static lottogame.view.Casher.askBuyPrice;
import static lottogame.view.Casher.informBuyCount;
import static lottogame.view.Casher.informPublishedLottos;
import static lottogame.view.Casher.informWinResult;

import java.util.Set;
import lottogame.model.lotto.LottoMachine;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;
import lottogame.model.lotto.WinningLottoNums;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public class LottoStore {

    public void start() {
        LottoPurchasePrice lottoPurchasePrice = getLottoPurchasePrice();

        Lottos lottos = buyLottos(lottoPurchasePrice);

        WinnerResult winnerResult = lottos.compareAndElectWinResult(getWinningLottoNums());

        informWinResult(winnerResult, lottoPurchasePrice);
    }

    /**
     * PurchasePrice : 구매금액
     * ManualCount : 수동 로또 수
     * ManualLottoNums : 수동 로또 번호목록
     * LottoPurchaseRequest : 위 내용을 담은 유저의 요청값 DTO -> record
     *
     * 유저 입력값 전달 프로세스 추상화
     * 로또 생성 방식 자동/수동 나눠서 처리
     *  수동 갯수에 따라 자동 갯수를 산출하는 행위가 필요하고 그에 따라 행위의 역할을 어떤 객체에게 설정할지 고민 필요
     *  전달받은 숫자 목록에 따라 로또를 생성하는 행위 필요 - Machine
     *  수동/자동은 생성후엔 기존 로또와 동일하게 인식되야함. -> 이후 요구사항이 다변화 되면 이넘/인터페이스/클래스 등으로 점점 나뉘는것.
     * 로또머신에서 LottoPurchaseRequest 전달받아 한번에 생성된 Lottos 제공 필요,
     * Lottos에 merge() 메서드 만들고 - tdd
     * */

    private LottoPurchasePrice getLottoPurchasePrice() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(askBuyPrice());
        informBuyCount(lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE));

        return lottoPurchasePrice;
    }

    private Lottos buyLottos(LottoPurchasePrice lottoPurchasePrice) {
        Lottos lottos = LottoMachine.createAutoLotto(lottoPurchasePrice);
        informPublishedLottos(lottos.convertRawString());
        return lottos;
    }

    private WinningLottoNums getWinningLottoNums() {
        Set<LottoNum> lottoByNums = LottoMachine.createLottoNums(askLottoNums());
        LottoNum bonusNum = LottoMachine.getLottoNum(askBonusNum());

        return new WinningLottoNums(lottoByNums, bonusNum);
    }
}
