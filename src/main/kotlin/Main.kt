import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Введите инф-цию, когда пользователь был в последний раз (в секундах):")
        println("Для окончания - введите 0")
        var lastTimeVisitInSec = scanner.nextInt()
        when {
            (lastTimeVisitInSec > 0) -> ageToText(lastTimeVisitInSec)
            lastTimeVisitInSec == 0 -> {
                println("Подсчет окончен.")
                break
            }
        }
    }
}

fun ageToText(lastTimeVisitInSec: Int) {
    val sec = 60
    var minutes = lastTimeVisitInSec / sec
    var hours = lastTimeVisitInSec / minutes
    when (lastTimeVisitInSec){
        in 0..60 -> println("Пользователь был(а) только что")
        in 61..3600 -> println("Пользователь был(а) $minutes ${minuteCase(lastTimeVisitInSec)} назад")
        in (60 * 60)..(24 * 60 * 60) -> println("Пользователь был(а) $hours ${hourCase(lastTimeVisitInSec)} назад")
        in (24 * 60 * 60 + 1)..(48 * 60 * 60) -> println("Пользователь был(а) вчера")
        in (48 * 60 * 60 +1)..(72 * 60 * 60) -> println("Пользователь был(а) позавчера")
        else -> println("Пользователь был(а) давно")
    }
}

fun minuteCase(lastTimeVisitInSec: Int): String {
    return when {
        lastTimeVisitInSec <= 60 -> "минуту "
        lastTimeVisitInSec in (60 * 2)..(60 * 4) -> "минуты "
        lastTimeVisitInSec in (5 * 60)..(20 * 60) || lastTimeVisitInSec in (25 * 60)..(30 * 60) -> "минут "
        (lastTimeVisitInSec / 60) % 10 == 1 -> "минуту "
        (lastTimeVisitInSec / 60) % 10 in 2..4 -> "минуты "
        else -> "минут "
    }
}

fun hourCase(lastTimeVisitInSec: Int): String {
    var hours = lastTimeVisitInSec * 60 * 60
    return when {
        hours == 1 -> "час "
        hours in 2..4 -> "часа "
        hours in 5..20 -> "часов "
        hours % 10 == 1 -> "час "
        hours % 10 in 2..4 -> "часа "
        else -> "часов "
    }
}