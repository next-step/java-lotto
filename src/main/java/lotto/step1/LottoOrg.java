package lotto.step1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LottoOrg {
    private static final LottoGen generator = new LottoGen();

    //로또 구매 함수
    public static List<Lotto> purchase(int money) {
        if (money < 1000) {
            throw new RuntimeException("로또 구입할 금액 부족");
        }

        int count = money / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generator.generate());
        }

        return lottos;
    }

    //구매자의 지갑에 있는 로또의 당첨 순위를 체크하는 함수
    //wallet       사용자 지갑
    //winnerNumber 당첨 번호
    //bonusBall    보너스 볼 번호

    public void allCheckInWallet(Wallet wallet, List<Integer> winnerNumber, int bonusBall) {
        wallet.getLottos().stream()
                .forEach(i -> i.grade = this.checkLotto(i, winnerNumber, bonusBall));
    }

    // 사용자 지갑의 로또 한 개에 대한 순위 체크 함수
    // lotto        로또 객체
    // winnerNumber 당첨 번호
    // bonusBall    보너스 볼 번호
    public static LottoGrade checkLotto(Lotto lotto, List<Integer> winnerNumber, int bonusBall) {
        int matchCount = Math.toIntExact(
                winnerNumber.stream().filter(integer -> lotto.getLotto().contains(integer)).count());
        if (matchCount < 3) {
            matchCount = 0;
        }
        return getLottoGrade(matchCount, lotto.getLotto().contains(bonusBall));
    }

    //로또의 당첨 순위를 반환하는 함수
    //customerMatchCount 번호를 맞힌 개수
    //hasBonus           보너스 볼 당첨 여부
    private static LottoGrade getLottoGrade(int customerMatchCount, boolean hasBonus) {
        return Arrays.stream(LottoGrade.values()).filter(
                        lottoGrade -> lottoGrade.getMatchCount() == customerMatchCount
                                && lottoGrade.getBonus() == hasBonus).findFirst()
                .orElse(LottoGrade.NO_GRADE);
    }
}
