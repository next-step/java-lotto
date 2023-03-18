package lotto.domain;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPromoter {
    
    private final List<LottoBall> balls = new ArrayList<>();
    
    public LottoPromoter() {
        initBalls();
    }

    private void initBalls() {
        for(int i = LottoBall.LOTTO_MIN_NUMBER; i <= LottoBall.LOTTO_MAX_NUMBER; i++) {
            balls.add(new LottoBall(i));
        }
    }

    public LottoGrades.LottoGrade checkLottoGrade(Lotto lotto, Lotto winningLotto, LottoBall bonusBall) {
        boolean hasBonusBall = lotto.getBalls().contains(bonusBall);
        long matchCount = lotto.getBalls().stream()
                .filter(ball -> winningLotto.getBalls().contains(ball) && ball != bonusBall)
                .count();

        return LottoGrades.getLottoGrade(matchCount, hasBonusBall);
    }

    public Map<LottoGrades.LottoGrade, Integer> checkLottoGrades(List<Lotto> lottos, Lotto winningLotto, LottoBall bonusBall) {
        Map<LottoGrades.LottoGrade, Integer> lottoGrades = new ConcurrentHashMap<>();
        lottos.stream()
                .forEach(lotto -> {
                    LottoGrades.LottoGrade grade = checkLottoGrade(lotto, winningLotto, bonusBall);
                    lottoGrades.put(grade, lottoGrades.getOrDefault(grade, 0) + 1);
                });
        return lottoGrades;
    }

    public int getPrizeMoney(Map<LottoGrades.LottoGrade, Integer> lottoResults) {
        int prizeMoney = 0;
        for(Map.Entry<LottoGrades.LottoGrade, Integer> lottoResult : lottoResults.entrySet()) {
            prizeMoney += (lottoResult.getKey().getPrizeMoney() * lottoResult.getValue());
        }

        return prizeMoney;
    }

    public Lotto buyLotto() {
        Collections.shuffle(balls);
        List<LottoBall> winningBalls = balls.subList(0, 6);
        return new Lotto(winningBalls);
    }

    public List<Lotto> buyLottos(int lottoCount) {
        if(lottoCount < 0) {
            throw new IllegalArgumentException("로또 구입 금액이 부족합니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(this.buyLotto());
        }
        return lottos;
    }

    public int getLottoCount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또를 구매하기 위해서는 1000원 이상의 금액이 필요합니다.");
        }

        return money / 1000;
    }

    public Lotto createLotto(List<Integer> numbers) {
        List<LottoBall> balls = new ArrayList<>();
        numbers.stream().forEach(number -> {
            LottoBall ball = new LottoBall(number);
            balls.add(ball);
        });

        return new Lotto(balls);
    }
}
