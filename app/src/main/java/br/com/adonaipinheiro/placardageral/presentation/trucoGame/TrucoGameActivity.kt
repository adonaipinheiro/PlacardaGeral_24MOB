package br.com.adonaipinheiro.placardageral.presentation.trucoGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.adonaipinheiro.placardageral.constants.ExtraConstants
import br.com.adonaipinheiro.placardageral.databinding.ActivityTrucoGameBinding

class TrucoGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrucoGameBinding

    private lateinit var trucoGameViewModel: TrucoGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        handleExtras()
        initViewModel()
        setupListeners()
        initObserver()
    }

    private fun initViewModel() {
        trucoGameViewModel = ViewModelProvider(this).get(TrucoGameViewModel::class.java)
    }

    private fun setupView() {
        binding = ActivityTrucoGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun handleExtras() {
        binding.tvHomeName.text = intent?.getStringExtra(ExtraConstants.PLAYER_HOME_NAME)
        binding.tvAwayName.text = intent?.getStringExtra(ExtraConstants.PLAYER_AWAY_NAME)
    }

    private fun setupListeners() {
        binding.btReset.setOnClickListener {
            trucoGameViewModel.resetGame()
        }

        binding.btMin1Home.setOnClickListener {
            trucoGameViewModel.scoreHome(-1)
        }

        binding.btMin1Away.setOnClickListener {
            trucoGameViewModel.scoreAway(-1)
        }

        binding.btPlus1Home.setOnClickListener {
            trucoGameViewModel.scoreHome(1)
        }

        binding.btPlus1Away.setOnClickListener {
            trucoGameViewModel.scoreAway(1)
        }

        binding.btPlus3Home.setOnClickListener {
            trucoGameViewModel.scoreHome(3)
        }

        binding.btPlus3Away.setOnClickListener {
            trucoGameViewModel.scoreAway(3)
        }

        binding.btPlus6Home.setOnClickListener {
            trucoGameViewModel.scoreHome(6)
        }

        binding.btPlus6Away.setOnClickListener {
            trucoGameViewModel.scoreAway(6)
        }

        binding.btPlus9Home.setOnClickListener {
            trucoGameViewModel.scoreHome(9)
        }

        binding.btPlus9Away.setOnClickListener {
            trucoGameViewModel.scoreAway(9)
        }

        binding.btPlus12Home.setOnClickListener {
            trucoGameViewModel.scoreHome(12)
        }

        binding.btPlus12Away.setOnClickListener {
            trucoGameViewModel.scoreAway(12)
        }

        binding.btFinish.setOnClickListener {
            finish()
        }
    }

    private fun initObserver() {
        trucoGameViewModel.homeScore.observe(this, {
            binding.tvHomeScore.text = "$it"
        })

        trucoGameViewModel.awayScore.observe(this, {
            binding.tvAwayScore.text = "$it"
        })
    }
}