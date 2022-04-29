class Client(var typeOfClient: TypeOfClient) {
    var car: CarPrice? = null
    fun improve() {
        if (typeOfClient == TypeOfClient.New) {
            typeOfClient = TypeOfClient.Important
        }
        if (typeOfClient == TypeOfClient.Important) {
            typeOfClient = TypeOfClient.VIP
        }

    }

}