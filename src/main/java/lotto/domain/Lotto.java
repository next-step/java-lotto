package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_LOWER_BOUND = 1;
    public static final int LOTTO_UPPER_BOUND = 46;
    public static final int LOTTO_FROM_INDEX = 0;
    public static final int LOTTO_LENGTH = 6;
    public static final List<Integer> LOTTO_NUMBERS = IntStream.range(LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());

    private List<Integer> lottoTicket;

    public Lotto(List<Integer> lottoTicket) {
        Collections.sort(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static Lotto initLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(LOTTO_FROM_INDEX, LOTTO_LENGTH));
    }

    public static Lotto initWinningLotto(List<String> winningNumbers) {
        lengthCheck(winningNumbers);

        List<Integer> lottoTickets = winningNumbers.stream()
                .map(Lotto::convertToInteger)
                .collect(Collectors.toList());

        return new Lotto(lottoTickets);
    }

    private static void lengthCheck(List<String> winningNumbers) {
        listSizeCheck(winningNumbers);
        sameNumberCheck(winningNumbers);
    }

    private static void listSizeCheck(List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요!");
        }
    }

    private static void sameNumberCheck(List<String> winningNumbers) {
        Set<String> numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("같은 번호가 있습니다!");
        }
    }

    private static int convertToInteger(String number) {
        try {
            return Integer.parseInt(number.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요!");
        }
    }

    public int getLottoSize() {
        return lottoTicket.size();
    }

    public boolean hasNumber(int number) {
        return lottoTicket.contains(number);
    }

    public int findMatchingBall(Lotto winningLotto) {
        return (int) lottoTicket.stream()
                .filter(winningLotto::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return "" + lottoTicket;
    }
}
