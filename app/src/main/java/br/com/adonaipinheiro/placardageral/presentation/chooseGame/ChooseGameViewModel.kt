package br.com.adonaipinheiro.placardageral.presentation.chooseGame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants

class ChooseGameViewModel : ViewModel() {

    var chosenGame: MutableLiveData<String> = MutableLiveData()

    init {
        chooseGame()
    }

    private fun chooseGame() {
        chosenGame.value = ExtraConstants.KEY_GAME_1
    }

    fun chooseGame(keyGame : Int) {
        when (keyGame) {
            1 -> chosenGame.value = ExtraConstants.KEY_GAME_1
            2 -> chosenGame.value = ExtraConstants.KEY_GAME_2
            3 -> chosenGame.value = ExtraConstants.KEY_GAME_3
            4 -> chosenGame.value = ExtraConstants.KEY_GAME_4
        }
    }
}