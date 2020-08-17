package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("로또 번호 랜덤 생성 테스트")
    @Test
    void create() {
        LottoTicket lottoTicket = LottoTicket.create();
        List<Integer> lottoNumbers = LottoTicket.getNumbers(lottoTicket);

        assertThat(lottoNumbers).hasSize(LottoTicket.DEFAULT_LOTTO_NUMBER_COUNT);
        assertThat(lottoNumbers.stream()
                .filter(number -> number > LottoNumber.MAX_VALUE || number < LottoNumber.MIN_VALUE)
                .findAny()).isEmpty();
    }

    @DisplayName("로또 당첨 번호 일치 개수 테스트")
    @ParameterizedTest
    @MethodSource("makeWinningLotto")
    void getMatchCountWith(List<LottoNumber> winningLotto) {
        LottoTicket lottoTicket = LottoTicket.create();
        int matchCount = lottoTicket.getMatchCountWith(winningLotto);

        List<Integer> originLottoNumbers = LottoTicket.getNumbers(lottoTicket);
        List<Integer> copiedLottoNumbers = new ArrayList<>(originLottoNumbers);

        copiedLottoNumbers.removeAll(winningLotto.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList()));

        int expectedMatchCount = originLottoNumbers.size() - copiedLottoNumbers.size();

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    private static Stream<Arguments> makeWinningLotto() {
        return Stream.iterate(0, i -> i++)
                .limit(5)
                .map(i -> makeWinningLottoRandom());
    }

    private static Arguments makeWinningLottoRandom() {
        Random random = new Random();
        List<LottoNumber> winningLotto = new ArrayList<>();

        Stream.iterate(0, i -> i++)
                .limit(6)
                .forEach(i -> winningLotto.add(LottoNumber.of(random.nextInt(45) + 1)));

        return Arguments.of(winningLotto);
    }
}
