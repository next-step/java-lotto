package service;

import model.LottoGame;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int calculateNumberOfGames(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<LottoGame> generateLottoGames(int numberOfGames) {
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            List<Integer> numbers = lottoNumberGenerator.getLottoNumbers();
            lottoGames.add(new LottoGame(numbers));
        }
        return lottoGames;
    }

    public List<Integer> getLottoNumbers(String input) {
        String[] numbers = input.split(", ");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }
}
