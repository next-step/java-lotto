/*
 * 로또 한장과, 로또의 묶음단위, 당첨 도메인들의 생성을 담당하는 팩토리 클래스
 * */
package lotto.domain;

import lotto.ui.InputView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.LOWER_LOTTONUMBER_BOUND;
import static lotto.domain.LottoNumber.UPPER_LOTTONUMBER_BOUND;

public class LottoFactory {

    private static LottoStrategy lottoStrategy; // 로또 생성 전략
    public static final LottoNumbers defaultLottoNumbers; // 1~45개의 번호를 갖는 기본 로또

    static {
        Set<LottoNumber> lottoNumberSet = new LinkedHashSet<>();
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= UPPER_LOTTONUMBER_BOUND; i++) {
            lottoNumberSet.add(new LottoNumber(i));
        }
        defaultLottoNumbers = new LottoNumbers(lottoNumberSet);
    }

    public static void setLottoStrategy(LottoStrategy strategy) {
        lottoStrategy = strategy;
    }

    /*
     * 설정해준 전략대로 로또를 생성한다.
     * */
    public static Lotto lotto() {
        return lottoStrategy.makeLotto();
    }

    /*
     * 원하는 갯수만큼의 로또들을 자동으로 생성한다.
     * */
    public static Lottos lottos(int total) {
        Lottos lottos = new Lottos(lottoList(total));
        return lottos;
    }

    /*
     * 수동과 자동을 섞은 로또를 생성한다.
     * */
    public static Lottos mixLottos(int total, int manualNum) {
        List<Lotto> lottoList = new ArrayList<>();
        // 수동으로 생성한다.
        lottoList.addAll(lottoList(
                InputView.inputManualLotto(manualNum)
        ));

        // 자동으로 생성한다.
        int autoNum = total - manualNum;
        setLottoStrategy(new AutoLottoStrategy());
        lottoList.addAll(lottoList(autoNum));
        return new Lottos(lottoList);
    }

    /*
     * 숫자만큼의 로또 리스트를 생성한다.
     * */
    private static List<Lotto> lottoList(int num) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoList.add(lotto());
        }
        return lottoList;
    }


    private static List<Lotto> lottoList(ArrayList<ArrayList<Integer>> numbers) {
        return numbers.stream()
                .map(LottoNumbers::of)
                .map(Lotto::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
     * 당첨번호와 보너스볼을 가지는 당첨번호를 생성한다.
     * */
    public static WinningNumbers winning(ArrayList<Integer> winningNumber, int bonusNumber) {
        return new WinningNumbers(LottoNumbers.of(winningNumber), new LottoNumber(bonusNumber));
    }

    /*
     * 로또들과 당첨번호를 토대로 통계치를 계산해주는 로또통계를 생성한다.
     * */
    public static WinningStatistics winningStatistics(Lottos lottos, WinningNumbers winningNumbers) {
        return new WinningStatistics(lottos, winningNumbers);
    }


}
