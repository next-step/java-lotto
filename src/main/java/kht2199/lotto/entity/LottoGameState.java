package kht2199.lotto.entity;

import kht2199.lotto.exception.DomainException;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.exception.input.InvalidInputException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;
import kht2199.lotto.view.RandomLottoUI;

public enum LottoGameState {
	INITIATING {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) {
			return ACCEPT_ASSETS;
		}
	},
	ACCEPT_ASSETS {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) throws AssetsException, InvalidInputException {
			int assets = ui.acceptAssets();
			game.initAssets(assets);
			return PURCHASE_MANUALLY;
		}
	},
	PURCHASE_MANUALLY {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) throws InvalidInputException, AssetsNotEnoughException {
			int count = ui.acceptLottoCountForManual();
			game.validatePurchasable(count);
			LottoList list = ui.acceptLotto(count);
			game.purchase(list);
			return PURCHASE_AUTOMATIC;
		}
	},
	PURCHASE_AUTOMATIC {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) throws AssetsNotEnoughException {
			int purchasableLottoCount = game.calculatePurchasableLottoCount();
			if (purchasableLottoCount != 0) {
				game.purchaseRandom(purchasableLottoCount);
			}
			return PURCHASED;
		}
	},
	PURCHASED {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) {
			LottoList purchasedLottoList = game.getPurchasedLottoList();
			ui.printLottoList(purchasedLottoList);
			return ACCEPT_WINNING_RESULT;
		}
	},
	ACCEPT_WINNING_RESULT {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) throws
				LottoNumberRangeException,
				LottoBonusNumberDuplicatedException,
				LottoNumberLengthException,
				InvalidInputException {
			Lotto winningNumbers = ui.acceptWinningNumbers();
			LottoNumber bonusNumber = ui.acceptBonusNumber();
			game.updateLottoWinningNumbers(winningNumbers, bonusNumber);
			return PRINT_STATISTICS;
		}
	},
	PRINT_STATISTICS {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) {
			ui.printResultStatistics(game);
			return ENDED;
		}
	},
	ENDED {
		@Override
		public LottoGameState process(RandomLottoUI ui, LottoGame game) {
			throw new RuntimeException("invalid state.");
		}
	},
	;

	public abstract LottoGameState process(RandomLottoUI ui, LottoGame game) throws DomainException;
}
