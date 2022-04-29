package cars

import Brand
import Car
import CarPrice
import Complectation

class Suv(color: String, complectation: Complectation, brand: Brand) : Car(color, complectation, brand), CarPrice {
    override val price: Int
        get() {
            var resultPrice = 0
            when (color) {
                "White" -> resultPrice = 20
                "Black" -> resultPrice = 30
                "Blue" -> resultPrice = 40
            }
            resultPrice += when (complectation) {
                Complectation.TOP -> 20
                Complectation.MID -> 10
                Complectation.LOW -> 5
            }
            resultPrice = when (brand) {
                Brand.BMW -> (resultPrice.toDouble() * 1.5).toInt()
                Brand.Audi -> (resultPrice.toDouble() * 1.2).toInt()
                Brand.Mersedes -> (resultPrice.toDouble() * 1.4).toInt()
            }
            return resultPrice
        }
}