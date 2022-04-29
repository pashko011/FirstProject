fun main() {

    val ourFactory = Factory()
    val ourDealer = Dealer()
    var input = ""
    do {
        println("Привет, я завод автомобилей, чем займемся?")
        val a: List<String>? = readLine()?.split(' ')
        input = a?.get(0).toString()
        val b = if ((a?.size ?: 0) > 1) a?.get(1)?.toInt()
        else 0
        when (input) {
            "work" -> ourFactory.work(b ?: 0)
            "sale" -> {
                ourFactory.sale(ourDealer, b ?: 0)
                println("Теперь у дилера ${ourDealer.dealersCar.size}")
            }
            "balans" -> {
                println("Сейчас у нас ${ourFactory.carList.size}")
                println("Теперь у дилера ${ourDealer.dealersCar.size}")
            }
            "exit" -> break
            "dealer_sale" -> {
                println("Бюджет дилера равен ${ourDealer.budgetDealer}")
                val car = ourDealer.saleToClient(Client(TypeOfClient.VIP))
                println("Дилер продал ${car.brand} ${car.color} ${car.complectation} за ${(car as CarPrice).price}, теперь его бюджет ${ourDealer.budgetDealer}")
            }
        }
        println("День окончен, баланс завода ${ourFactory.budget}")
    } while (true)
    println("")

}