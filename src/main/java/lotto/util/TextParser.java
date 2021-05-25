package lotto.util;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 문자 파서.
 */
public class TextParser {
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";
    private static final String DELIMITER = ",";
    private static final int VALID_LOTTO_COUNT = 6;
    public static final String INVALID_LOTTO_COUNT_ERROR = "로또의 갯수가 올바르지 않습니다. 입력된 갯수: ";

    private TextParser() {
    }

    /**
     * 문자를 입력받아 로또 번호를 리턴한다.
     *
     * @param text 입력받은 텍스트
     * @return 로또 번호 목록
     */
    public static List<LottoNumber> parseToLottoNumbers(String text) {
        final List<LottoNumber> lottoNumbers = getLottoNumbers(text);
        if (lottoNumbers.size() != VALID_LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT_ERROR + lottoNumbers.size());
        }
        return lottoNumbers;
    }

    private static List<LottoNumber> getLottoNumbers(String text) {
        return Stream.of(text.split(DELIMITER))
                .map(String::trim)
                .map(TextParser::parseToInt)
                .map(LottoNumber::of)
                .collect(toList());
    }

    public static int parseToInt(String inputText) {
        try {
            return (Integer.parseUnsignedInt(inputText));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER + e.getMessage());
        }
    }
}
