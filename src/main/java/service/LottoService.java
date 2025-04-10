package service;

import model.Lotto;
import model.LottoResult;
import model.Lottos;
import model.Result;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1_000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos create(int purchasePrice) {
        int numberOfGames = calculateNumberOfGames(purchasePrice);
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            List<Integer> numbers = lottoNumberGenerator.getLottoNumbers();
            list.add(new Lotto(numbers));
        }
        return new Lottos(list);
    }

    private int calculateNumberOfGames(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Integer> getLottoNumbers(String input) {
        String[] numbers = input.split(", ");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }

    public Result getResult(Lottos lottos, String winningNumbersStr) {
        List<Integer> winningNumbers = getLottoNumbers(winningNumbersStr);
        Result result = new Result(winningNumbers, lottos);



    }


}
