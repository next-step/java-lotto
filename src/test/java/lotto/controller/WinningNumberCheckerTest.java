package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Digit;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class WinningNumberCheckerTest {
	@DisplayName("당첨 번호와 내 번호를 비교해서 일치하는 개수 반환")
	@Test
	void 당첨번호와_내번호를_비교해서_일치하는_개수_반환() {
		int number = 1;
		List<Digit> winningNumbers = new ArrayList<>(6);
		winningNumbers.add(new Digit(1));
		winningNumbers.add(new Digit(2));
		winningNumbers.add(new Digit(3));
		winningNumbers.add(new Digit(4));
		winningNumbers.add(new Digit(5));
		winningNumbers.add(new Digit(6));

		List<Lottos> lottosList = new ArrayList<>(1);
		Lottos lottos = new Lottos();
    	lottosList.add(lottos);
		for (Lottos lottoNumbers : lottosList){
			lottoNumbers.lottos().add(Lotto.valueOf("ONE"));
        	lottoNumbers.lottos().add(Lotto.valueOf("TWO"));
        	lottoNumbers.lottos().add(Lotto.valueOf("THREE"));
        	lottoNumbers.lottos().add(Lotto.valueOf("FOUR"));
        	lottoNumbers.lottos().add(Lotto.valueOf("FIVE"));
        	lottoNumbers.lottos().add(Lotto.valueOf("SIX"));
		}

		int[] result = WinningNumberChecker.check(winningNumbers, lottosList, number);

		assertThat(result[0] == 6).isTrue();
	}
}
