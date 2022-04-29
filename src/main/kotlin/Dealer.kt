import TypeOfClient.*
import kotlin.random.Random


class Dealer() {
    var dealersCar: MutableList<CarPrice> = mutableListOf()
    var budgetDealer = 200

    fun saleToClient(client: Client): Car {
        val position = Random.nextInt(0, dealersCar.size)
        val car = dealersCar[position]
        val coefficient = when (client.typeOfClient) {
            VIP -> 0.9
            Important -> 1.1
            New -> 1.2
        }
        val resultPrice = car.price * coefficient
        budgetDealer += resultPrice.toInt()
        dealersCar.removeAt(position)
        return car as Car
    }

    fun servicecar() {


    }


}