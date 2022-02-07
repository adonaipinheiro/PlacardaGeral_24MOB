package br.com.adonaipinheiro.placardageral.presentation.basketGame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketGameViewModel: ViewModel() {
    val homeScore: MutableLiveData<Int> = MutableLiveData()
    val awayScore: MutableLiveData<Int> = MutableLiveData()

    init {
        startGame()
    }

    fun resetGame() {
        startGame()
    }

    fun scoreHome(points: Int) {
        homeScore.value = homeScore.value?.plus(points)
    }

    fun scoreAway(points: Int) {
        awayScore.value = awayScore.value?.plus(points)
    }

    private fun startGame() {
        homeScore.value = 0
        awayScore.value = 0
    }
}