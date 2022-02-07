package br.com.adonaipinheiro.placardageral.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.adonaipinheiro.placardageral.R
import br.com.adonaipinheiro.placardageral.presentation.players.PlayersActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        nextScreen()
    }

    private fun nextScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val nextScreen = Intent(this, PlayersActivity::class.java)
            startActivity(nextScreen)
            finish()
        }, 2000)
    }
}