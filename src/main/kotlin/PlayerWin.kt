class PlayerWin : Result() {
    override fun printResult(player: InfoPlayer?) {
        println("Pemain ${player!!.playerNumber} Menang!")
    }
}