package lotto

import kotlin.math.floor

data class LottoPrizes(val prizes: List<LottoPrize> = emptyList()) {
    private val prizeEachCountMap = prizes.groupingBy { it.name }.eachCount()

    val prizeResult = LottoPrize.values().filter { it.price > 0 }
        .map { Pair(it, prizeEachCountMap.getOrDefault(it.name, 0)) }

    fun earnings(purchaseMoney: PurchaseMoney): Double {
        val total = prizes.sumOf { it.price }
        return floor(total.toDouble() / purchaseMoney.money.toDouble() * 100) / 100
    }
}

enum class LottoPrize(val matchCount: Int, val price: Int) {
    NONE(0, 0),
    FIRST(1, 0),
    SECOND(2, 0),
    THIRD(3, 5_000),
    FORTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(6, 30_000_000),
    SIXTH(6, 2_000_000_000);

    companion object {

        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize {
            return when {
                matchCount == FIFTH.matchCount && matchBonus -> FIFTH_BONUS
                matchCount == THIRD.matchCount -> THIRD
                matchCount == FORTH.matchCount -> FORTH
                matchCount == FIFTH.matchCount -> FIFTH
                matchCount == SIXTH.matchCount -> SIXTH
                else -> NONE
            }
        }
    }
}