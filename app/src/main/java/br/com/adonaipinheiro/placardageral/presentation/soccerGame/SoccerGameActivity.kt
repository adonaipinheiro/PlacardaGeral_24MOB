package br.com.adonaipinheiro.placardageral.presentation.soccerGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants
import br.com.adonaipinheiro.placardageral.databinding.ActivityBasketGameBinding
import br.com.adonaipinheiro.placardageral.databinding.ActivitySoccerGameBinding
import br.com.adonaipinheiro.placardageral.presentation.basketGame.BasketGameViewModel

class SoccerGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoccerGameBinding

    private lateinit var soccerGameViewModel: SoccerGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()
        handleExtras()
        initObserver()
        setupListeners()
    }

    private fun initView() {
        binding = ActivitySoccerGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViewModel() {
        soccerGameViewModel = ViewModelProvider(this).get(SoccerGameViewModel::class.java)
    }

    private fun handleExtras() {
        binding.tvHomeName.text = intent?.getStringExtra(ExtraConstants.PLAYER_HOME_NAME)
        binding.tvAwayName.text = intent?.getStringExtra(ExtraConstants.PLAYER_AWAY_NAME)
    }

    private fun initObserver() {
        soccerGameViewModel.homeScore.observe(this, {
            binding.tvHomeScore.text = "$it"
        })

        soccerGameViewModel.awayScore.observe(this, {
            binding.tvAwayScore.text = "$it"
        })
    }

    private fun setupListeners() {
        binding.btReset.setOnClickListener {
            soccerGameViewModel.resetGame()
        }

        binding.btPlus1Home.setOnClickListener {
            soccerGameViewModel.scoreHome(1)
        }

        binding.btPlus1Away.setOnClickListener {
            soccerGameViewModel.scoreAway(1)
        }

        binding.btFinish.setOnClickListener {
            finish()
        }
    }
}