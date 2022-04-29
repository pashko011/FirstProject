import Brand.*
import Complectation.*
import cars.Miniven
import cars.Sedan
import cars.Suv
import kotlin.random.Random

class Factory {
    var budget: Int = 300
    var carList = mutableListOf<Car>()
    fun work(b: Int) {
        for (i in 0 until b) {
            val x = Random.nextInt(0, 3)
            val car: Car = when (x) {
                0 -> {
                    println("Я создал SUV")
                    Suv("Blue", LOW, Audi)
                }
                1 -> {
                    println("Я создал Седан")
                    Sedan("White", MID, Mersedes)
                }
                2 -> {
                    println("Я создал Минивен")
                    Miniven("Black", TOP, BMW)
                }
                else -> Miniven("Black", TOP, BMW)
            }
            carList.add(car)
            budget -= (car as CarPrice).price
        }
        println("Сейчас у нас ${carList.size}")
    }

    fun sale(ourDealer: Dealer, b: Int) {
        ourDealer.dealersCar.addAll(carList.take(b).map { it as CarPrice }.toMutableList())
        carList.take(b).forEach { car ->
            val factorySellOut = (car as CarPrice).price * 1.5
            budget = (budget + factorySellOut).toInt()
            ourDealer.budgetDealer -= factorySellOut.toInt()
        }
        for (i in 0 until b) {
            println(
                    when (carList.first()) {
                        is Miniven -> "Продали Минивен"
                        is Suv -> "Продали SUV"
                        is Sedan -> "Продали Седан"
                        else -> "ошибка"
                    }
            )
            carList.removeFirst()
        }
        println("Сейчас у нас ${carList.size}")
    }
}