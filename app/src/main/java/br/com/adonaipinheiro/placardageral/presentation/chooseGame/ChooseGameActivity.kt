package br.com.adonaipinheiro.placardageral.presentation.chooseGame

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants
import br.com.adonaipinheiro.placardageral.databinding.ActivityChooseGameBinding
import br.com.adonaipinheiro.placardageral.presentation.basketGame.BasketGameActivity
import br.com.adonaipinheiro.placardageral.presentation.players.PlayersActivity
import br.com.adonaipinheiro.placardageral.presentation.soccerGame.SoccerGameActivity
import br.com.adonaipinheiro.placardageral.presentation.trucoGame.TrucoGameActivity
import kotlin.reflect.KType

class ChooseGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseGameBinding

    private lateinit var chooseGameViewModel: ChooseGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupListeners()
        initViewModel()
    }

    private fun initViewModel() {
        chooseGameViewModel = ViewModelProvider(this).get(ChooseGameViewModel::class.java)
    }

    private fun setupListeners() {
        binding.gameBox1.setOnClickListener {
            chooseGameViewModel.chooseGame(1)
            binding.gameBox1.isSelected = true
            binding.gameBox2.isSelected = false
            binding.gameBox3.isSelected = false
            binding.gameBox4.isSelected = false
        }

        binding.gameBox2.setOnClickListener {
            chooseGameViewModel.chooseGame(2)
            binding.gameBox1.isSelected = false
            binding.gameBox2.isSelected = true
            binding.gameBox3.isSelected = false
            binding.gameBox4.isSelected = false
        }

        binding.gameBox3.setOnClickListener {
            chooseGameViewModel.chooseGame(3)
            binding.gameBox1.isSelected = false
            binding.gameBox2.isSelected = false
            binding.gameBox3.isSelected = true
            binding.gameBox4.isSelected = false
        }

        binding.gameBox4.setOnClickListener {
            Toast.makeText(this, "Ainda não implementado", Toast.LENGTH_LONG).show()
        }

        binding.btChooseGame.setOnClickListener {
            when (chooseGameViewModel.chosenGame.value) {
                ExtraConstants.KEY_GAME_1 -> navigateTo(TrucoGameActivity())
                ExtraConstants.KEY_GAME_2 -> navigateTo(SoccerGameActivity())
                ExtraConstants.KEY_GAME_3 -> navigateTo(BasketGameActivity())
                ExtraConstants.KEY_GAME_4 -> navigateTo(PlayersActivity())
            }
        }
    }

    private fun setupView() {
        binding = ActivityChooseGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun navigateTo(activity: Activity) {
        var bundle: Bundle? = intent?.extras
        var nextScreen = Intent(this, activity::class.java)
        nextScreen.putExtra(ExtraConstants.PLAYER_HOME_NAME, bundle?.getString(ExtraConstants.PLAYER_HOME_NAME))
        nextScreen.putExtra(ExtraConstants.PLAYER_AWAY_NAME, bundle?.getString(ExtraConstants.PLAYER_AWAY_NAME))
        startActivity(nextScreen)
    }

}