fun main() {
    val inp = "CMXCIV"

    val arrOfDigits = inp.toCharArray()
    var res = 0
    var i = 0

    while (i in arrOfDigits.indices) {
        val digit = arrOfDigits[i]
        val digitNext = if (i + 1 < arrOfDigits.size) arrOfDigits[i + 1] else '0'

        val term = checkComplexDigit(digit, digitNext)
        if (term > 0) {
            res += term
            i += 2
            continue
        } else res += getArabicValue(digit)

        i++
    }

    println(res)
}

fun getArabicValue(digit: Char): Int {
    var res = 0
    when (digit) {
        'I' -> res = 1
        'V' -> res = 5
        'X' -> res = 10
        'L' -> res = 50
        'C' -> res = 100
        'D' -> res = 500
        'M' -> res = 1000
    }
    return res
}

fun checkComplexDigit(digit: Char, nextDigit: Char) : Int {
    when (digit) {
        'I' -> when (nextDigit) {
            'V' -> return 4
            'X' -> return 9
            else -> return 0
        }

        'X' -> when (nextDigit) {
            'L' -> return 40
            'C' -> return 90
            else -> return 0
        }

        'C' -> when (nextDigit) {
            'D' -> return 400
            'M' -> return 900
            else -> return 0
        }

        else -> return 0
    }

}