package br.com.adonaipinheiro.placardageral.presentation.players

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import br.com.adonaipinheiro.placardageral.R
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants
import br.com.adonaipinheiro.placardageral.databinding.ActivityPlayersBinding
import br.com.adonaipinheiro.placardageral.presentation.chooseGame.ChooseGameActivity

class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupListeners()
    }

    private fun setupView() {
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btChooseGame.setOnClickListener() {
            val nextScreen = Intent(this, ChooseGameActivity::class.java)
            nextScreen.putExtra(ExtraConstants.PLAYER_HOME_NAME, binding.etPlayer1.text.toString())
            nextScreen.putExtra(ExtraConstants.PLAYER_AWAY_NAME, binding.etPlayer2.text.toString())
            previewRequest.launch(nextScreen)
        }
    }

    private val previewRequest =
        registerForActivityResult((ActivityResultContracts.StartActivityForResult())) {
            if (it.resultCode == RESULT_OK) {
                TODO()
            }
        }
}