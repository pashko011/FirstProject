import TypeOfClient.*
import kotlin.random.Random


class Dealer() {
    var carList: MutableList<CarPrice> = mutableListOf()
    var budget = 200

    fun saleToClient(client: Client): Car {
        val position = Random.nextInt(0, carList.size)
        val car = carList[position]
        val coefficient = calculateCoefficient(client)
        val resultPrice = car.price * coefficient
        budget += resultPrice.toInt()
        carList.removeAt(position)
        client.car = car
        return car as Car
    }


    fun serviceCar(client: Client) : Int {
        val coefficient = calculateCoefficient(client)
        val priceOfService = ((client.car?.price ?: 0) * 0.07 * coefficient).toInt()
        budget += priceOfService
        client.improve()
        return priceOfService

    }

    private fun calculateCoefficient(client: Client): Double {
        val coefficient = when (client.typeOfClient) {
            VIP -> 0.9
            Important -> 1.1
            New -> 1.2
        }
        return coefficient
    }
}