package lotto.model

@JvmInline
value class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    init {
        require((MIN_NUMBER <= number) and (number <= MAX_NUMBER)) {
            "lottoNumber must be between $MIN_NUMBER and $MAX_NUMBER. but provided number(`$number`)"
        }
    }

    operator fun rangeTo(other: LottoNumber): Collection<LottoNumber> {
        return (number..other.number).map { LottoNumber(it) }
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val MIN: LottoNumber = LottoNumber(MIN_NUMBER)
        val MAX: LottoNumber = LottoNumber(MAX_NUMBER)
    }
}
