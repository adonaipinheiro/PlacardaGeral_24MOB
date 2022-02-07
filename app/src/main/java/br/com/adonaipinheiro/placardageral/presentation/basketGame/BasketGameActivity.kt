package br.com.adonaipinheiro.placardageral.presentation.basketGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants
import br.com.adonaipinheiro.placardageral.databinding.ActivityBasketGameBinding
import br.com.adonaipinheiro.placardageral.presentation.trucoGame.TrucoGameViewModel

class BasketGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasketGameBinding

    private lateinit var basketGameViewModel: BasketGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()
        handleExtras()
        initObserver()
        setupListeners()
    }

    private fun initView() {
        binding = ActivityBasketGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViewModel() {
        basketGameViewModel = ViewModelProvider(this).get(BasketGameViewModel::class.java)
    }

    private fun handleExtras() {
        binding.tvHomeName.text = intent?.getStringExtra(ExtraConstants.PLAYER_HOME_NAME)
        binding.tvAwayName.text = intent?.getStringExtra(ExtraConstants.PLAYER_AWAY_NAME)
    }

    private fun initObserver() {
        basketGameViewModel.homeScore.observe(this, {
            binding.tvHomeScore.text = "$it"
        })

        basketGameViewModel.awayScore.observe(this, {
            binding.tvAwayScore.text = "$it"
        })
    }

    private fun setupListeners() {
        binding.btReset.setOnClickListener {
            basketGameViewModel.resetGame()
        }

        binding.btPlus1Home.setOnClickListener {
            basketGameViewModel.scoreHome(1)
        }

        binding.btPlus1Away.setOnClickListener {
            basketGameViewModel.scoreAway(1)
        }

        binding.btPlus3Home.setOnClickListener {
            basketGameViewModel.scoreHome(3)
        }

        binding.btPlus3Away.setOnClickListener {
            basketGameViewModel.scoreAway(3)
        }

        binding.btFinish.setOnClickListener {
            finish()
        }
    }
}