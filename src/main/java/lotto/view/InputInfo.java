package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.exception.LottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputInfo {

    private static final String ERR_MESSAGE_NUMBER_FORMAT = "로또 입력값이 아닙니다.";
    private static final String ERR_MESSAGE_LOTTO_SIZE = "입력 숫자는 6개 입니다.";
    private static final String MESSAGE_LOTTO_COUNT = "%d개를 구입하였습니다.";
    private static final String SPLIT_REGEX = ",";
    private static final String ANSWER_BLANK = " ";
    private static final String ANSWER_EMPTY = "";

    public InputInfo(String price) {
        System.out.println(String.format(MESSAGE_LOTTO_COUNT, Lottos.getCount(price)));
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
