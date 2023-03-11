package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoOrganizer {

    private static final LottoGenerator generator = new LottoGenerator();

    /**
     * 로또 구매 함수
     *
     * @param money 금액
     * @return
     */
    public static List<Lotto> purchase(int money) {
        if (money < 1000) {
            throw new RuntimeException("로또를 구입할 금액이 부족합니다.");
        }
        int count = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generator.generate());
        }

        return lottos;
    }

    /**
     * 구매자의 지갑에 있는 로또의 당첨 순위를 체크하는 함수
     *
     * @param wallet       사용자 지갑
     * @param winnerNumber 당첨 번호
     * @param bonusBall    보너스 볼 번호
     */
    public void allCheckInWallet(Wallet wallet, List<Integer> winnerNumber, int bonusBall) {
        wallet.getLottos().stream()
            .forEach(i -> i.grade = this.checkLotto(i, winnerNumber, bonusBall));
    }

    /**
     * 사용자 지갑의 로또 한 개에 대한 순위 체크 함수
     *
     * @param lotto        로또 객체
     * @param winnerNumber 당첨 번호
     * @param bonusBall    보너스 볼 번호
     * @return
     */
    public static LottoGrade checkLotto(Lotto lotto, List<Integer> winnerNumber, int bonusBall) {
        int matchCount = Math.toIntExact(
            winnerNumber.stream().filter(integer -> lotto.getLotto().contains(integer)).count());
        if (matchCount < 3) {
            matchCount = 0;
        }
        return getLottoGrade(matchCount, lotto.getLotto().contains(bonusBall));
    }

    /**
     * 로또의 당첨 순위를 반환하는 함수
     *
     * @param customerMatchCount 번호를 맞힌 개수
     * @param hasBonus           보너스 볼 당첨 여부
     * @return
     */
    private static LottoGrade getLottoGrade(int customerMatchCount, boolean hasBonus) {
        return Arrays.stream(LottoGrade.values()).filter(
                lottoGrade -> lottoGrade.getMatchCount() == customerMatchCount
                    && lottoGrade.getBonus() == hasBonus).findFirst()
            .orElse(LottoGrade.NO_GRADE);
    }
}
