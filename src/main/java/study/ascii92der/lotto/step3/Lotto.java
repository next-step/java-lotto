package study.ascii92der.lotto.step3;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_VALID_COUNT = 6;
    public static final String ERROR_MASSAGE_WRONG_NUMBER_COUNT = "Lotto Number count is wrong";
    public static final String ERROR_MASSAGE_DUPLICATE_NUMBER = "This Numbers has duplicate number";
    private List<LottoNumber> lottoNumbers;

    public Lotto(String lottoString) {
        lottoNumbers = new ArrayList<>();
        String[] lottoArray = parseLottoString(lottoString);
        validNumberCount(lottoArray);
        validDuplicateNumber(lottoArray);

        for (String value : lottoArray) {
            lottoNumbers.add(new LottoNumber(value));
        }
    }

    private void validNumberCount(String[] lottoArray) {
        if(lottoArray.length != LOTTO_NUMBER_VALID_COUNT){
            throw new IllegalArgumentException(ERROR_MASSAGE_WRONG_NUMBER_COUNT);
        }
    }

    private void validDuplicateNumber(String[] lottoArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(lottoArray));
        if (lottoNumberSet.size() != lottoArray.length) {
            throw new IllegalArgumentException(ERROR_MASSAGE_DUPLICATE_NUMBER);
        }
    }

    private String[] parseLottoString(String lottoString) {
        return lottoString.replaceAll("[^0-9,]", "")
                .split(",");
    }

}
