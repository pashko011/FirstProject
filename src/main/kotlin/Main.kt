import kotlin.random.Random

fun main() {

    val ourFactory = Factory()
    val ourDealer = Dealer()
    val clientList: MutableList<Client> = mutableListOf()
    var input: String
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
                println("Теперь у дилера ${ourDealer.carList.size}")
            }
            "balans" -> {
                println("Сейчас у нас ${ourFactory.carList.size}")
                println("Теперь у дилера ${ourDealer.carList.size}")
            }
            "exit" -> break
            "service_car" -> {
                val position = Random.nextInt(0, clientList.size)
                val client = clientList[position]
                println("На сервис приехал клиент ${client.typeOfClient}")
                val priceOfService = ourDealer.serviceCar(client)
                println("Статус клиента повышен до ${client.typeOfClient}, стоимость сервиса составила $priceOfService")

            }
            "dealer_sale" -> {
                println("Бюджет дилера равен ${ourDealer.budget}")
                val c = Random.nextInt(0, 3)
                val client = Client(
                        when (c) {
                            0 -> TypeOfClient.VIP
                            1 -> TypeOfClient.Important
                            2 -> TypeOfClient.New
                            else -> TypeOfClient.New
                        }
                )
                clientList.add(client)
                val car = ourDealer.saleToClient(client)
                println("Дилер продал ${client.typeOfClient} ${car.brand} ${car.color} ${car.complectation} за ${(car as CarPrice).price}, теперь его бюджет ${ourDealer.budget}")
            }
        }
        println("День окончен, баланс завода ${ourFactory.budget}")
        println("Баланс дилера ${ourDealer.budget}")

    } while (true)
    println("")

}