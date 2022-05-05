package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;

public class WinningLotto {

  private static final String WINNING_LOTTO_BASED_SPLIT_REGEX = ", ";
  private static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> winningLottoNumbers;

  public WinningLotto(List<LottoNumber> winningLottoNumbers) {
    validateDuplicateNumber(winningLottoNumbers);
    this.winningLottoNumbers = winningLottoNumbers;
  }

  private void validateDuplicateNumber(List<LottoNumber> winningLottoNumbers) {
    Set<LottoNumber> validateLottoNumbers = new HashSet<>(winningLottoNumbers);
    if (validateLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new LottoNumberDuplicateException(winningLottoNumbers);
    }
  }

  public static WinningLotto create(String winningLotto) {
    String[] splitWinningLotto = splitWinningLotto(winningLotto);
    List<LottoNumber> winningLottoNumbers = new ArrayList<>();
    for (String lottoNumber : splitWinningLotto) {
      winningLottoNumbers.add(LottoNumber.create(convertToNumber(lottoNumber)));
    }
    return new WinningLotto(winningLottoNumbers);
  }

  private static String[] splitWinningLotto(String winningLotto) {
    return winningLotto.split(WINNING_LOTTO_BASED_SPLIT_REGEX);
  }

  public List<LottoNumber> getWinningLottoNumbers() {
    return winningLottoNumbers;
  }

  public boolean contains(LottoNumber lottoNumber) {
    return winningLottoNumbers.contains(lottoNumber);
  }

  private static int convertToNumber(String winningLottoNumber) {
    return Integer.parseInt(winningLottoNumber);
  }
}
