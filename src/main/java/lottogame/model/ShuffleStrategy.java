package lottogame.model;

//수정..필요..
@FunctionalInterface
public interface ShuffleStrategy {
    LottoNumbers shuffle(final LottoNumbers numbers);
}
