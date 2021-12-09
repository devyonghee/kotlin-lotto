package lotto.view

import lotto.domain.Lotto

class InputView {
    private lateinit var winningNums: Lotto

    fun readMoney(): Int {
        println(INPUT_MONEY_MSG)
        return validateMoney(readLine())
    }

    fun readWinningNums(): Lotto {
        println(INPUT_WINNING_NUMS_MSG)
        return parseToWinningNums(readLine())
    }

    fun parseToWinningNums(nums: String?): Lotto {
        require(nums != null) { INVALID_WINNING_NUMS_EXCEPTION_MSG }

        val stringNums = nums.split(WINNING_NUM_DELIMITER)
        winningNums = Lotto(stringNums.map { convertToLottoNum(it) }.toSet())
        return winningNums
    }

    private fun convertToLottoNum(num: String?): Int {
        require(num != null && num.toIntOrNull() != null) { INVALID_WINNING_NUMS_EXCEPTION_MSG }
        return num.toInt()
    }

    fun readBonusNum(): Int {
        println(INPUT_BONUS_NUM_MSG)
        return validateBonusNum(readLine(), winningNums)
    }

    companion object {
        private const val INPUT_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val INVALID_MONEY_EXCEPTION_MSG = "구입금액을 바르게 입력해 주세요. (숫자만 가능)"
        private const val INPUT_WINNING_NUMS_MSG = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUM_MSG = "보너스 볼을 입력해 주세요."
        private const val INVALID_WINNING_NUMS_EXCEPTION_MSG =
            "당첨 번호를 바르게 입력해 주세요. (1 ~ 45 사이의 서로 다른 6개의 숫자를 쉼표로 구분하여 입력)"
        private const val INVALID_BONUS_NUM_EXCEPTION_MSG =
            "보너스 번호를 바르게 입력해 주세요. (입력한 당첨 번호 이외의 1 ~ 45 사이의 숫자 입력)"
        private val WINNING_NUM_DELIMITER = ",\\s*".toRegex()

        fun validateMoney(money: String?): Int {
            require(money != null && money.toIntOrNull() != null) { INVALID_MONEY_EXCEPTION_MSG }
            return money.toInt()
        }

        fun validateBonusNum(bonusNum: String?, winningNums: Lotto): Int {
            require(bonusNum != null && bonusNum.toIntOrNull() != null) { INVALID_BONUS_NUM_EXCEPTION_MSG }

            val resultNum = bonusNum.toInt()
            require(Lotto.NUM_RANGE.contains(resultNum)) { INVALID_BONUS_NUM_EXCEPTION_MSG }
            require(!winningNums.nums.contains(resultNum)) { INVALID_BONUS_NUM_EXCEPTION_MSG }
            return resultNum
        }
    }
}