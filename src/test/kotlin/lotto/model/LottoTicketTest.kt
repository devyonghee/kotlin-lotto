package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("로또 티켓")
class LottoTicketTest : StringSpec({

    "로또 번호는 6개" {
        shouldNotThrowAny {
            LottoTicket((1..6).map(::LottoNumber).toSet())
        }
    }

    "로또 번호가 6개가 아니면 예외 발생" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket((1..5).map(::LottoNumber).toSet())
        }
    }

    "1 ~ 6 로또 티켓의 일치하는 개수 반환" {
        (1..7).map {
            LottoTicket((it..it + 5).map(::LottoNumber).toSet()) to (7 - it)
        }.forAll {
            ONE_TO_SIX_LOTTO_TICKET matchedCount it.first shouldBe it.second
        }
    }
})

val ONE_TO_SIX_LOTTO_TICKET = LottoTicket((1..6).map(::LottoNumber).toSet())
