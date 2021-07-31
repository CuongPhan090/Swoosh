package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        var player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        tbSkillBaller.setOnClickListener{
            tbSkillBeginner.isChecked = false
            if (player != null) {
                player.skill = "Baller"
            }
        }

        tbSkillBeginner.setOnClickListener{
            tbSkillBaller.isChecked = false
            if (player != null) {
                player.skill = "Beginner"
            }
        }

        btnSkillFinish.setOnClickListener{
            if (tbSkillBaller.isChecked || tbSkillBeginner.isChecked) {
                val skillIntent = Intent(this, FinishActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            }
            else {
                Toast.makeText(this, "Please select your skill!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}