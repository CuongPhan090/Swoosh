package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {
    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        tbLeagueMens.setOnClickListener{
            tbLeagueWomens.isChecked = false
            tbLeagueCoed.isChecked = false
            selectedLeague = "Mens"
        }

        tbLeagueWomens.setOnClickListener{
            tbLeagueMens.isChecked = false
            tbLeagueCoed.isChecked = false
            selectedLeague = "Womens"
        }

        tbLeagueCoed.setOnClickListener{
            tbLeagueWomens.isChecked = false
            tbLeagueMens.isChecked = false
            selectedLeague = "Co-ed"
        }

        btnLeagueNext.setOnClickListener() {
            if (tbLeagueWomens.isChecked || tbLeagueMens.isChecked || tbLeagueCoed.isChecked) {
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
                startActivity(skillIntent)
            }
            else {
                Toast.makeText(this, "Please pick your league!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}