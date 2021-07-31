package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        tbLeagueMens.setOnClickListener{
            tbLeagueWomens.isChecked = false
            tbLeagueCoed.isChecked = false
            player.league = "Mens"
        }

        tbLeagueWomens.setOnClickListener{
            tbLeagueMens.isChecked = false
            tbLeagueCoed.isChecked = false
            player.league = "Womens"
        }

        tbLeagueCoed.setOnClickListener{
            tbLeagueWomens.isChecked = false
            tbLeagueMens.isChecked = false
            player.league = "Co-ed"
        }

        btnLeagueNext.setOnClickListener() {
            if (tbLeagueWomens.isChecked || tbLeagueMens.isChecked || tbLeagueCoed.isChecked) {
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            }
            else {
                Toast.makeText(this, "Please pick your league!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("Life cycle", "On start")
    }

    override fun onResume() {
        super.onResume()
        Log.v("Life cycle", "on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("Life cycle", "on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("Life cycle", "on Stop")
    }
}