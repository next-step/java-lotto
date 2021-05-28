package lottery.fixture;

import static lottery.LottoNumber.*;

import java.util.Set;

import org.assertj.core.util.Sets;

import lottery.LottoNumber;

public class Const {
	public static final Set<LottoNumber> buyer_로또번호_1_2_3_11_12_13 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(11),
		of(12),
		of(13));

	public static final Set<LottoNumber> buyer_로또번호_1_2_3_4_12_13 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(4),
		of(12),
		of(13));
	public static final Set<LottoNumber> buyer_로또번호_1_2_3_4_5_13 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(4), of(5),
		of(13));
	public static final Set<LottoNumber> buyer_로또번호_1_2_3_4_5_6 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(4), of(5),
		of(6));
	public static final Set<LottoNumber> buyer_로또번호_1_2_3_9_10_11 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(9),
		of(10),
		of(11));
	public static final Set<LottoNumber> 로또번호_1_2_3_4_5_6 = Sets.newLinkedHashSet(of(1), of(2), of(3), of(4), of(5), of(6));
	public static final LottoNumber 보너스_7 = LottoNumber.of(7);

}
