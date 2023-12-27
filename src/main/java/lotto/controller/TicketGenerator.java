package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lottos;

public class TicketGenerator {
	public static List<Lottos> generate(final int number){
		List<Lottos> entireLottos = new ArrayList<>();

		for (int i = 0; i < number; i++) {
			entireLottos.add(new Lottos(LottosGenerator.generate()));
		}

		return entireLottos;
	}
}
