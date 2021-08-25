import utils.Name
import utils.PlayerName

class App {
    companion object {
        private lateinit var playerName: PlayerName
        val firstPlayer = InfoPlayer(1)
        val secondPlayer = InfoPlayer(2)
        private val Choice: List<String> = arrayListOf("gunting", "batu", "kertas")

        @JvmStatic
        fun main(args: Array<String>) {
            App().start()
        }
    }

    private fun start() {
        playerName = PlayerName()
        header()
        inputPlayerName()
        inputPlayer(firstPlayer)
        inputPlayer(secondPlayer)

        println("Hasil: ")
        process(firstPlayer, secondPlayer)
    }

    private fun header() {
        println(
            """
            ==========================
            Game Suit Terminal Version
            ==========================
        """.trimIndent()
        )
    }

    private fun inputPlayerName(){
        println("Masukan Nama Pemain 1 = ")
        val namePlayerOne = readLine().orEmpty()
        println("Masukan Nama Pemain 2 = ")
        val namePlayerTwo = readLine().orEmpty()
        println("Selamat Bertanding ${playerName.name(namePlayerOne)} VS ${playerName.name(namePlayerTwo)}")
    }

    private fun inputPlayer(player: InfoPlayer) {
        do {
            println("${player.playerNumber}. Masukan Pilihan Pemain ${player.playerNumber}:")
            player.choose = readLine()?.toLowerCase() ?: ""
            val condition = player.choose == "" || !Choice.contains(player.choose)

            if (condition) {
                println("Pilihan tidak ada (Masukan (batu/gunting/kertas)")
            }
        } while (condition)
    }

    private fun process(firstPlayer: InfoPlayer, secondPlayer: InfoPlayer) {
        if (firstPlayer.choose == secondPlayer.choose) {
            PlayerDraw().printResult(null)
        } else if (firstPlayer.choose == "batu" && secondPlayer.choose == "gunting" ){
            PlayerWin().printResult(firstPlayer)
        } else if (firstPlayer.choose == "gunting" && secondPlayer.choose == "kertas"){
            PlayerWin().printResult(firstPlayer)
        } else if (firstPlayer.choose == "kertas" && secondPlayer.choose == "batu") {
            PlayerWin().printResult(firstPlayer)
        } else if (firstPlayer.choose == "kertas" && secondPlayer.choose == "gunting"){
            PlayerWin().printResult(secondPlayer)
        } else if (firstPlayer.choose == "gunting" && secondPlayer.choose == "batu"){
            PlayerWin().printResult(secondPlayer)
        } else if (firstPlayer.choose == "batu" && secondPlayer.choose == "kertas") {
            PlayerWin().printResult(secondPlayer)
        }
    }
}
