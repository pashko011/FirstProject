package cars

import Brand
import Car
import CarPrice
import Complectation

class Suv(color: String, complectation: Complectation, brand: Brand) : Car(color, complectation, brand), CarPrice {
    override val price: Int
        get() {
            var resultPrice: Int = 0
            when (color) {
                "White" -> resultPrice = 20
                "Black" -> resultPrice = 30
                "Blue" -> resultPrice = 40
            }
            when (complectation) {
                Complectation.TOP -> resultPrice += 20
                Complectation.MID -> resultPrice += 10
                Complectation.LOW -> resultPrice += 5
            }
            when (brand) {
                Brand.BMW -> resultPrice = (resultPrice.toDouble() * 1.5).toInt()
                Brand.Audi -> resultPrice = (resultPrice.toDouble() * 1.2).toInt()
                Brand.Mersedes -> resultPrice = (resultPrice.toDouble() * 1.4).toInt()
            }
            return resultPrice
        }
}