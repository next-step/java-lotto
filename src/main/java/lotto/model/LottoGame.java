package lotto.model;

import java.util.*;

import static java.util.stream.Collectors.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public List<Lotto> createLotto(int totalPrice) throws IllegalArgumentException {
        validation(totalPrice);

        int lottoTicketCount = totalPrice / LOTTO_PRICE;

        this.lottos = new ArrayList<>();
        for(int i= 0; i< lottoTicketCount; i++) {
            Lotto lotto = new Lotto(LottoNumbers.getAutoNumbers());
            this.lottos.add(lotto);
        }

        return lottos;
    }

    public LottoGameResult getReword(String stringNumber) {
        Lotto winnerLotto = createWinnerLotto(stringNumber);
        LottoGameResult lottoGameResult = new LottoGameResult();

        for (Lotto lotto : lottos) {
            lottoGameResult.setRewordCount(lotto, winnerLotto);
        }

        return lottoGameResult;
    }

    private Lotto createWinnerLotto(String stringNumber) {
        List<String> numbers = Arrays.asList(stringNumber.replace(" ", "").split(","));
        return new Lotto(new ArrayList(numbers.stream().map(Integer::parseInt).collect(toList())));
    }

    private void validation(int totalPrice) {
        validationTotalPrice(totalPrice);
    }

    private void validationTotalPrice(int totalPrice) {
        if(totalPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매금액은 1000원이 넘어야 합니다.");
        }
    }


}
