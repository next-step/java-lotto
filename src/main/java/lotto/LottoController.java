package lotto;

import lotto.domain.*;
import lotto.utils.LottoShuffle;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    public static final int LOTTO_GAME_PRICE = 1000;
    private static final int MISS_ZERO = 0;
    private int totalGame;
    private int autoGame;
    private int selectGame;
    private List<Lotto> lottos;
    private List<Prize> rankResult;


    public LottoController(Money money, int selectLottoCount) {

        this.totalGame = money.canBuyLottoGameCount();
        if (totalGame < selectLottoCount) {
            throw new IllegalArgumentException("수동게임이 총 게임수를 넘어갈 수 없습니다.");
        }
        this.autoGame = totalGame - selectLottoCount;
        this.selectGame = selectLottoCount;
        rankResult = new ArrayList();
        lottos = new ArrayList<>();
    }

    public void createLottoWithUserInput() {
        lottos.addAll(Input.inputSelectLottonumber(this.selectGame));
    }

    public void createLottoWithRandom() {

        for (int i = 0; i < autoGame; i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

    }

    public void matchLotto(WinningLotto winningLotto) {

        for (Lotto lotto : lottos) {
            int count = winningLotto.getMatchCount(lotto);
            boolean hasBounusNumber = winningLotto.isContainBonusNumber(lotto);
            match(count, hasBounusNumber);
        }
    }

    private void match(int count, boolean hasBounusNumber) {

        Prize prize = Prize.findByPrize(count, hasBounusNumber);
        rankResult.add(prize);

    }

    public Revenue getRevenueStatic() {
        long totalSum = 0;
        for (Prize prize : this.rankResult) {
            totalSum = prize.sumMoney(totalSum);
        }

        return new Revenue(totalSum,  totalGame );
    }

    public void printBuyLottoGames() {
        Output.printBuyLottoNumber(lottos);
    }

    public void printCountAutoAndSelectGame() {
        Output.printAutoCountSelectCount(autoGame, selectGame);
    }

    public void printResultWinningStatic() {


        List<String> resultStatics = Arrays.stream(Prize.values())
                .filter(prize -> !prize.isSameMatchCount(MISS_ZERO))
                .map(prize -> {
                    int prizeCount = getPrizeCount(prize);
                    return makeDetailString(prizeCount, prize);
                }).collect(Collectors.toList());

        Output.printResultWinningStatic(resultStatics);
    }

    private String makeDetailString(int prizeCount, Prize prize) {
        String detail = prize.getMatchCount() + "개 일치";
        if (prize == Prize.SECOND) {
            detail += "보너스 볼 일치";
        }

        return detail + "(" + prize.getMoney() + "원) -" + prizeCount + "개";

    }

    private int getPrizeCount(Prize prize) {
        return (int) rankResult.stream()
                .filter(result -> result == prize)
                .count();
    }

    public void printRevenueStatic() {
        Output.printResultRevenu(getRevenueStatic());
    }


}
