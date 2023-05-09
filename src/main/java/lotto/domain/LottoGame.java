package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constants.LOTTO_PRICE;

public class LottoGame {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator, List<Lotto> lottos) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottos = lottos;
    }

    public void buyLotto(int price) {
        checkPrice(price);
        int lottoCount = price / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private List<LottoMatcher> matchResult(List<LottoNumber> winNumber, LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winNumber, bonusNumber))
                .collect(Collectors.toList());
    }

    private static void checkPrice(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException("로또 구매 비용이 부족합니다.");
        }
    }

    public LottoScore score(List<Integer> winNumbers, Integer bonusNumber) {
        checkNumbers(winNumbers, bonusNumber);
        return new LottoScore(matchResult(toLottoNumbers(winNumbers), toLottoNumber(bonusNumber))
        );
    }

    private LottoNumber toLottoNumber(Integer bonusNumber) {
        return new LottoNumber(bonusNumber);
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> winNumbers) {
        return winNumbers.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    private void checkNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        if (isDuplicateNumber(winNumbers)) {
            throw new IllegalArgumentException("중복된 번호가 입력되었습니다.");
        }
        if (existNumber(winNumbers, bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 번호입니다.");
        }
        if (checkNumberOfCount(winNumbers)) {
            throw new IllegalArgumentException("로또 당첨번호는 6개 입니다.");
        }
    }

    private static boolean checkNumberOfCount(List<Integer> winNumbers) {
        return winNumbers.size() != 6;
    }

    private static boolean existNumber(List<Integer> winNumbers, Integer bonusNumber) {
        return winNumbers.contains(bonusNumber);
    }

    private static boolean isDuplicateNumber(List<Integer> winNumbers) {
        return winNumbers.size() != new HashSet<>(winNumbers).size();
    }

    public int quantity() {
        return lottos.size();
    }
}
