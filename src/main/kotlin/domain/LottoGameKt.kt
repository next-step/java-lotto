package domain

class LottoGameKt() {

    val lottos: MutableList<LottoKt> = mutableListOf()

    fun buyLotto(price: Int) {
        for (i in 0 until sizeOfLotto(price)) {
            lottos.add(LottoKt.auto())
        }
    }

    private fun sizeOfLotto(price: Int) = price / LottoKt.PRICE

    fun getLottoCount(): Int {
        return lottos.size
    }
}