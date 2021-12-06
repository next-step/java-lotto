package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.exception.LottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputInfo {

    public static final int LOTTO_PRICE = 1000;
    private static final String ERR_MESSAGE_NUMBER_FORMAT = "숫자형식 입력값이 아닙니다.";
    private static final String ERR_MESSAGE_LOTTO_SIZE = "입력 숫자는 6개 입니다.";
    private static final String MESSAGE_LOTTO_COUNT = "%d개를 구입하였습니다.";
    private static final String SPLIT_REGEX = ",";
    private static final String ANSWER_BLANK = " ";
    private static final String ANSWER_EMPTY = "";

    private final int lottoCount;

    public InputInfo(String price) {

        try {
            int lottoPrice = Integer.parseInt(price);
            this.lottoCount = lottoPrice / LOTTO_PRICE;
            System.out.println(String.format(MESSAGE_LOTTO_COUNT, this.lottoCount));
        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Integer> getAnswer(String answer) {
        List<Integer> answers;
        try {
            String answerLump = answer.replace(ANSWER_BLANK, ANSWER_EMPTY);
            String[] answerSplit = answerLump.split(SPLIT_REGEX);
            List<String> answerNumbers = Arrays.asList(answerSplit);
            answers = answerNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new LottoNumberException(ERR_MESSAGE_NUMBER_FORMAT);
        }
        valid(answers);
        return answers;
    }

    public void valid(List<Integer> answer) {
        if (answer.size() != LottoNumbers.MARKED_RANGE) {
            throw new LottoNumberException(ERR_MESSAGE_LOTTO_SIZE);
        }
    }
}
