package domain

class LottoGameKt() {

    val lottos: MutableList<LottoKt> = mutableListOf()

    fun buyLotto(price: Int) {
        for (i in 0 until price / LottoKt.PRICE) {
            lottos.add(LottoKt())
        }
    }

    fun getLottoCount(): Int {
        return lottos.size
    }
}